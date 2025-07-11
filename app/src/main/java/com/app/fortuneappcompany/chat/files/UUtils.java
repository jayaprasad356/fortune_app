package com.app.fortuneappcompany.chat.files;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import com.app.fortuneappcompany.chat.managers.Utils;

import java.io.File;

class UUtils {
    private static String failReason;

    static String errorReason() {
        return failReason;
    }

    @SuppressLint("NewApi")
    static String getRealPathFromURI_API19(final Context context, final Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri)) {
            Utils.sout("*** 1");

            if (isExternalStorageDocument(uri)) {
                Utils.sout("*** 1.1");
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    if (split.length > 1) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    } else {
                        return Environment.getExternalStorageDirectory() + "/";
                    }
                } else {
                    // Some devices does not allow access to the SD Card using the UID, for example /storage/6551-1152/folder/video.mp4
                    // Instead, we first have to get the name of the SD Card, for example /storage/sdcard1/folder/video.mp4

                    // We first have to check if the device allows this access
                    if (new File("storage" + "/" + docId.replace(":", "/")).exists()) {
                        return "/storage/" + docId.replace(":", "/");
                    }
                    // If the file is not available, we have to get the name of the SD Card, have a look at SDUtils
                    String[] availableExternalStorages = SDUtil.getStorageDirectories(context);
                    String root = "";
                    for (String s : availableExternalStorages) {
                        if (split[1].startsWith("/")) {
                            root = s + split[1];
                        } else {
                            root = s + "/" + split[1];
                        }
                    }
                    if (root.contains(type)) {
                        return "storage" + "/" + docId.replace(":", "/");
                    } else {
                        if (root.startsWith("/storage/") || root.startsWith("storage/")) {
                            return root;
                        } else if (root.startsWith("/")) {
                            return "/storage" + root;
                        } else {
                            return "/storage/" + root;
                        }
                    }
                }

            } else if (isRawDownloadsDocument(uri)) {
                Utils.sout("*** 1.2");
                String fileName = getFilePath(context, uri);
                String subFolderName = getSubFolders(uri);

                if (fileName != null) {
                    Utils.sout("Return from HERE ::::::::::::::::::::::::::: " + subFolderName + fileName);
//                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + subFolderName + fileName;
                }

                try {
                    final String id = DocumentsContract.getDocumentId(uri);
                    final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));
                    Utils.sout("---- fileName:: " + subFolderName + " >> " + fileName + " ==> " + id + " >> " + contentUri);
                    return getDataColumn(context, contentUri, null, null);
                } catch (Exception e) {
                    Utils.sout("Next Exception ::::::::::::::::::");
                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + subFolderName + fileName;
                }

            } else if (isDownloadsDocument(uri)) {
                Utils.sout("*** 1.3");
                String fileName = getFilePath(context, uri);

                if (fileName != null) {
                    String path = Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName;
                    Utils.sout("*** 1.3 fileName:: " + fileName + " >> " + uri);
                    Utils.sout("*** 1.3 uri:: " + DocumentsContract.getDocumentId(uri) + " >Exist file?::: " + new File(path).exists());
//                    if (new File(path).exists()) {
//                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName;
//                    }
                }
                String id = DocumentsContract.getDocumentId(uri);
                Utils.sout("*** 1.3 :::id::: " + id);
                if (id.startsWith("raw:")) {
                    id = id.replaceFirst("raw:", "");
                    File file = new File(id);
                    if (file.exists())
                        return id;
                }
                if (id.startsWith("raw%3A%2F")) {
                    id = id.replaceFirst("raw%3A%2F", "");
                    File file = new File(id);
                    if (file.exists())
                        return id;
                }
                //Solution from this link: https://github.com/Javernaut/WhatTheCodec/issues/2#issuecomment-779767009
                if (id.startsWith("msf:")) {
                    id = id.replaceFirst("msf:", "");
                    Utils.sout("msf 1: " + id);
                    return FileUtils.fileCopyFromCache(context, uri);
                }
                if (id.startsWith("msf%3A%2F")) {
                    id = id.replaceFirst("msf%3A%2F", "");
                    Utils.sout("msf 2: " + id);
                    return FileUtils.fileCopyFromCache(context, uri);
                }

//                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
//                return getDataColumn(context, contentUri, null, null);
                try {
                    Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));

                    String data = getDataColumn(context, contentUri, null, null);
                    if (data != null) {
                        Utils.sout("*** 1.3 content:: " + contentUri);
                        return data;
                    } else {
                        Utils.sout("*** 1.3 fileCopyFromCache");
                        return FileUtils.fileCopyFromCache(context, uri);
                    }
                } catch (Exception e) {
                    Utils.getErrors(e);
                    Utils.sout("Next Exception 1.3*** ::::::::::::::::::: " + e.getMessage());
                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName;
                }
            } else if (isMediaDocument(uri)) {
                Utils.sout("*** 1.4");
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            Utils.sout("*** 2");
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            if (getDataColumn(context, uri, null, null) == null) {
                failReason = "dataReturnedNull";
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            Utils.sout("*** 3");
            return uri.getPath();
        }

        return null;
    }

    private static String getSubFolders(Uri uri) {
        String replaceChars = String.valueOf(uri).replace("%2F", "/").replace("%20", " ").replace("%3A", ":");
        String[] bits = replaceChars.split("/");
        String sub5 = bits[bits.length - 2];
        String sub4 = bits[bits.length - 3];
        String sub3 = bits[bits.length - 4];
        String sub2 = bits[bits.length - 5];
        String sub1 = bits[bits.length - 6];
        if (sub1.equals("Download")) {
            return sub2 + "/" + sub3 + "/" + sub4 + "/" + sub5 + "/";
        } else if (sub2.equals("Download")) {
            return sub3 + "/" + sub4 + "/" + sub5 + "/";
        } else if (sub3.equals("Download")) {
            return sub4 + "/" + sub5 + "/";
        } else if (sub4.equals("Download")) {
            return sub5 + "/";
        } else {
            return "";
        }
    }

    static String getRealPathFromURI_BelowAPI19(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Video.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } catch (Exception e) {
            failReason = e.getMessage();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    @SuppressWarnings("TryFinallyCanBeTryWithResources")
    private static String getFilePath(Context context, Uri uri) {
        Cursor cursor = null;
        final String[] projection = {MediaStore.Files.FileColumns.DISPLAY_NAME};
        try {
            cursor = context.getContentResolver().query(uri, projection, null, null,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME);
                return cursor.getString(index);
            }
        } catch (Exception e) {
            failReason = e.getMessage();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }


    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isRawDownloadsDocument(Uri uri) {
        String uriToString = String.valueOf(uri);
        return uriToString.contains("com.android.providers.downloads.documents/document/raw");
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }


    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

}
