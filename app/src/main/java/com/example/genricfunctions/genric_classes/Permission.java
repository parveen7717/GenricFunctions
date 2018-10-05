package com.example.genricfunctions.genric_classes;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

/****************
 * Class to check Storage permission manually
 */

public class Permission {
    private Activity activity;
    public static int IMAGE_STOREAGE_PERMISSION=100;
    public static int IMAGE_REQUEST_CODE_ASK_PERMISSIONS = 201;
    public Permission(Activity activity) {
        this.activity=activity;
    }

    public boolean checkStorage(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
                    || activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED
                    || activity.checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED)
            {
                activity.requestPermissions(new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE
                        ,Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ,Manifest.permission.CAMERA},IMAGE_STOREAGE_PERMISSION);
                return false;
            }
            else {
                return true;
            }
        }else {
            return true;
        }
    }
}
