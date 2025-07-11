package com.app.fortuneappcompany.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Constant {
//    public static final String MainBaseUrl = "https://admin.fortuneapp.in/";
    public static final String MainBaseUrl = "https://admin.fortuneapp.in/";
    //public static final String MainBaseUrl = "https://fortune.graymatterworks.com/";
    //public static final String MainBaseUrl = "http://192.168.43.38/fortune/";
    //public static final String MainBaseUrl = "https://demofortune.graymatterworks.com/";
    //public static final String MainBaseUrl = "https://demo.fortuneapp.in/";
    public static final String BaseUrl = MainBaseUrl + "api/";
    public static final String SEND_ADMIN_NOTIFY_URL = BaseUrl + "sendadminnotify.php";
    public static final String LOGIN_URL = BaseUrl + "login.php";
    public static final String IMPORT_DATA_URL = BaseUrl + "import_data.php";
    public static final String REGISTER_URL = BaseUrl + "register.php";
    public static final String WALLET_URL = BaseUrl + "wallet.php";
    public static final String UPDATE_USER_URL = BaseUrl + "updateuser.php";
    public static final String USER_DETAILS_URL = BaseUrl + "userdetails.php";
    public static final String UPDATE_BANK_URL = BaseUrl + "updatebank.php";
    public static final String WITHDRAWAL_URL = BaseUrl + "withdrawal.php";
    public static final String SUSPECT_CODES_URL = BaseUrl + "suspect_codes.php";
    public static final String WITHDRAWAL_LIST_URL = BaseUrl + "withdrawal_lists.php";
    public static final String NOTIFICATION_LIST_URL = BaseUrl + "notification_lists.php";
    public static final String CHANGE_DEVICE_LIST_URL = BaseUrl + "change_device.php";
    public static final String APPUPDATE_URL = BaseUrl + "appupdate.php";
    public static final String TRNSACTION_LIST_URL = BaseUrl + "transaction_lists.php";
    public static final String BANK_DETAILS_URL = BaseUrl + "bank_details.php";
    public static final String SETTINGS_URL = BaseUrl + "settings.php";
    public static final String CHAMPION_TASK_TRIAL = BaseUrl + "championtask_trial.php";

    public static final String SWITCH_CHAMPIONTASK = BaseUrl + "switch_championtask.php";

    public static final String URLS_LIST_URL = BaseUrl + "urls_list.php";

    public static final String REFERALSLIST = BaseUrl + "referalslist.php";
    public static final String ADD_WALLET = BaseUrl + "add-wallet.php";

    public static final String PER_CODE_VAL = "per_code_val";

    public static final String APPLY_LEAVE_URL = BaseUrl + "applyleave.php";
    public static final String MYLEAVES_LIST_URL = BaseUrl + "myleaves_list.php";



    public static final String LEAVE_DATE = "leave_date";
    public static final String REASON = "reason";

    public static final String TOTAL_LEAVES = "total_leaves";


    public static final String ID = "id";
    public static final String PROFILE = "profile";
    public static final String DEVICE_VERIFY = "device_verify";
    public static final String LEVEL = "level";
    public static final String USER_VERIFY = "user_verify";
    public static final String USER_ID = "user_id";
    public static final String MOBILE = "mobile";
    public static final String SYNC_UNIQUE_ID = "sync_unique_id";
    public static final String STUDENT_NAME = "student_name";
    public static final String ID_NUMBER = "id_number";
    public static final String BLACK_BOX = "black_box";
    public static final String ECITY = "ecity";
    public static final String PIN_CODE = "pin_code";
    public static final String CODES = "codes";
    public static final String IMPORT_DATA = "import_data";
    public static final String ACCOUNT_NUM = "account_num";
    public static final String HOLDER_NAME = "holder_name";
    public static final String BANK = "bank";
    public static final String BRANCH = "branch";
    public static final String IFSC = "ifsc";
    public static final String EARN = "earn";
    public static final String WITHDRAWAL = "withdrawal";
    public static final String TOTAL_REFERRALS = "total_referrals";
    public static final String LAST_UPDATED_DATE = "last_updated_date";
    public static final String LAST_UPDATED_DATE_STATUS = "last_updated_date_status";
    public static final String RUN_API = "run_api";
    public static final String FCM_ID = "fcm_id";
    public static final String WORK_ACTIVITY = "work_activity";

    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String BALANCE = "balance";
    public static final String REFER_CODE = "refer_code";
    public static final String TODAY_CODES = "today_codes";
    public static final String TOTAL_CODES = "total_codes";

    public static final String SUCCESS = "success";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String SETTINGS = "settings";
    public static final String BANK_DETAILS = "bank_details";
    public static final String USER_DETAILS = "user_details";
    public static final String LINK = "link";
    public static final String DESCRIPTION = "description";
    public static final String VERSION = "version";
    public static final String MY_TASK = "my_task";


    public static final String DATE = "date";
    public static final String DOB = "dob";

    public static final String AMOUNT = "amount";
    public static final String TYPE = "type";
    public static final String ORGANIZER_ID = "organizer_id";
    public static final String CITY = "city";
    public static final String PINCCODE = "pincode";
    public static final String PASSWORD = "password";
    public static final String PAYMENT_LINK = "payment_link";
    public static final String DEVICE_ID = "device_id";
    public static final String STATUS = "status";
    public static final String WORKED_DAYS = "worked_days";
    public static final String REFERRED_BY = "referred_by";
    public static final String REFER_BONUS_SENT = "refer_bonus_sent";
    public static final String CODE_GENERATE = "code_generate";
    public static final String CODE_GENERATE_TIME = "code_generate_time";
    public static final String LAST_UPDATED = "last_updated";
    public static final String JOINED_DATE = "joined_date";
    public static final String WITHDRAWAL_STATUS = "withdrawal_status";
    public static final String SYNC_TIME = "sync_time";
    public static final String MY_REPAYMENT_LIST_URL = BaseUrl + "my_repayment_list.php";
    public static final String SA_WITHDRAWAL_URL = BaseUrl + "sa_withdrawal.php";

    public static final String MY_SA_TRANSLIST_URL = BaseUrl + "my_sa_translist.php";
    public static final String APP_VERSION = "app_version";


    public static final String CHECKIN = "checkin";
    public static final String WHATSAPP = "whatsapp";
    public static final String JOB_DETAILS_LINK = "job_details_link";
    public static final String CHAT_SUPPORT = "chat_support";
    public static final String PENDING_TICKET = "pending_ticket";
    public static final String CLOSED_TICKET = "closed_ticket";
    public static final String TITLE = "title";
    public static final String CATEGORY = "category";
    public static final String SYNC_CODES = "sync_codes";
    public static final String MIN_WITHDRAWAL = "min_withdrawal";
    public static final String AD_STATUS = "ad_status";
    public static final String REWARD = "reward";
    public static final String AD_SHOW_TIME = "ad_show_time";
    public static final String FETCH_TIME = "fetch_time";
    public static final String AD_REWARD_ID = "ad_reward_id";
    public static final String JOIN_CODES = "join_codes";
    public static final String REFER_BONUS_CODES = "refer_bonus_codes";
    public static final String REFER_BONUS_AMOUNT = "refer_bonus_amount";
    public static final String REFER_DESCRIPTION = "refer_description";
    public static final String CHAMPION_TASK = "champion_task";
    public static final String URL = "url";
    public static final String CHAMPION_CODES = "champion_codes";
    public static final String TASK_TYPE = "task_type";
    public static final String CHAMPION_DEMO_LINK = "champion_demo_link";
    public static final String CHAMPION = "champion";
    public static final String MAIN_CONTENT = "main_content";
    public static final String 	CLOSED_JOINING = "closed_joining";
    public static final String 	FOLLOWUP_TICKET = "followup_ticket";
    public static final String REFER_INCOME = "refer_income";
    public static final String REFER_LIST_DATA = "refer_list_data";
    public static final String SYNC_REFER_WALLET = "sync_refer_wallet";
    public static final String CHAMPION_SEARCH_COUNT = "champion_search_count";
    public static final String 	TRIAL_COUNT = "trial_count";
    public static final String 	MCG_TIMER = "mcg_timer";
    public static final String CHAMPION_TASK_ELIGIBLE = "champion_task_eligible";

    public static final String 	CHAMPION_TRIAL_COUNT = "champion_trial_count";
    public static final String JOINING_TICKET = "joining_ticket";
    public static final String TRIAL_EXPIRED = "trial_expired";

    public static final String AD_TYPE = "ad_type";
    public static final String AD_AVAILABLE = "ad_available";
    public static final String LAST_UPDATED_SETTINGS_DATE = "last_updated_settings_date";
    public static final String LAST_UPDATED_DATE_SETTINGS = "last_updated_date_settings";
    public static final String RISE_TICKET_STATUS = "rise_ticket_status";
    public static final String LAST_UPDATED_DATE_AD = "last_updated_date";
    public static final String LAST_UPDATED_DATE_STATUS_AD = "last_updated_date_status";
    public static final String SUPPORT = "support";
    public static final String TIMESTAMP = "timestamp";
    public static final String 	SECURITY = "security";
    public static final String ONGOING_SA_BALANCE = "ongoing_sa_balance";
    public static final String SALARY_ADVANCE_BALANCE = "salary_advance_balance";
    public static final String SA_REFER_COUNT = "sa_refer_count";
    public static final String 	REGULAR_TRIAL_COUNT = "regular_trial_count";
    public static final String REGULAR = "regular";
    public static final String FAQ_LIST = BaseUrl + "faq_list.php";
    public static final String 	CHECK_NOTIFICATION = "check_notification";
    public static final String IMPORT_URLS = "import_urls";
    public static final String EXPLORE_URL = BaseUrl + "explore.php";

    @SuppressLint("HardwareIds")
    public static final  String getDeviceId(Activity activity) {

        String deviceId;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            deviceId = android.provider.Settings.Secure.getString(activity.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            // Toast.makeText(context,  deviceId, Toast.LENGTH_SHORT).show();

        } else {

            final TelephonyManager mTelephony = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);


            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = android.provider.Settings.Secure.getString(activity.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
                //  Toast.makeText(LoginActivity.this,  deviceId, Toast.LENGTH_SHORT).show();
            }
        }

        return deviceId;

    }
    public static final String getCurrentDate(){
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = df.format(c);
        return formattedDate;
    }
    public static final  String getHistoryDays(String joinDate) {
        Date userDob = null;
        int numOfDays = 0;
        Date today = new Date();
        try {
            userDob = new SimpleDateFormat("yyyy-MM-dd").parse(joinDate);
            long diff =  today.getTime() - userDob.getTime();
            int numOfYear = (int) ((diff / (1000 * 60 * 60 * 24))/365);
            numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
            int hours = (int) (diff / (1000 * 60 * 60));
            int minutes = (int) (diff / (1000 * 60));
            int seconds = (int) (diff / (1000));


        } catch (ParseException e) {
            e.printStackTrace();
        }




        return ("" + (int) numOfDays);
    }
}