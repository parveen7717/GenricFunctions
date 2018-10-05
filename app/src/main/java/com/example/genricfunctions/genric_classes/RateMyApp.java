package com.example.genricfunctions.genric_classes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

public class RateMyApp extends DialogFragment {
    Button yes_del, No_del;
    static Context context;
    static RateMyApp mRateApp;

    public static RateMyApp newInstance(Context context) {
        RateMyApp.context = context;
        if (mRateApp == null)
            mRateApp = new RateMyApp();
        return mRateApp;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Rate This App")
                .setMessage("Please give your valuable feedback")
                .setPositiveButton("Rate This App",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                // DO SOMETHING
                                //Open Google Play Store And Provide the Link of App

                                final String appPackageName = this.getClass().getPackage().toString(); // getPackageName() from Context or Activity object
                                try {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                } catch (android.content.ActivityNotFoundException anfe) {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                                }
                                mRateApp.dismiss();
                            }
                        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // DO SOMETHING
                        mRateApp.dismiss();
                    }
                }).create();
    }

}
