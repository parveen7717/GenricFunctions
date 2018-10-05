package com.example.genricfunctions.genric_classes;

import android.util.Log;

import com.example.genricfunctions.BuildConfig;

/***************
 * This class is used to print logs
 */

public class LOGS {
    public static void system(String message,String result){
        if(BuildConfig.DEBUG){
            Log.d("--"+message,result);
            //System.out.println("----------------------------------------------------------"+message+":"+result);
        }
    }
}
