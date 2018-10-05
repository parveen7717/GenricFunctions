package com.example.genricfunctions.genric_classes;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/***********
 * Class will check application is in foreground or background
 */

public class CheckApplicationBackGround {
    /*if app is in running condition it return true*/
    public static boolean isForeground(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : tasks) {
            if (ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND == appProcess.importance && packageName.equals(appProcess.processName)) {
                return true;
            }
        }
        return false;
    }
}
