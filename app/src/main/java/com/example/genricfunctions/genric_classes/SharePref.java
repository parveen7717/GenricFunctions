package com.example.genricfunctions.genric_classes;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Profile";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_PROFILE_IMAGE = "profileImage";
    public static final String KEY_DOB = "dob";
    public static final String KEY_PHONE_NO = "phoneNo";
    public static final String KEY_LOG_IN = "login";


    // Constructor
    public SharePref(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


}
