package com.app.fortuneappcompany.chat.files;

interface CallBackTask {
    void PickerManagerOnUriReturned();

    void PickerManagerOnPreExecute();

    void PickerManagerOnProgressUpdate(int progress);

    void PickerManagerOnPostExecute(String path, boolean wasDriveFile, boolean wasSuccessful, String reason);
}
