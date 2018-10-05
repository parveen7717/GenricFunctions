package com.example.genricfunctions.genric_classes;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.genricfunctions.BuildConfig;
import com.example.genricfunctions.R;

import java.io.File;
import java.io.IOException;


/*************
 * This class controls the camera and Gallery
 */

public class CameraController {
    private Activity activity;
    Dialog dialog_camera;
    public static Uri uriiii;
    public static int GET_IMAGE_GALLARY = 102;
    public static int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 103;
    Permission permission;

    public CameraController(Activity activity) {
        this.activity = activity;
        permission = new Permission(activity);
    }


    public void OpenCam() {
        dialog_camera = new Dialog(activity);
        dialog_camera.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_camera.setContentView(R.layout.custom_camera_dialog);
        dialog_camera.setCancelable(false);
        FrameLayout cam_cancel = (FrameLayout) dialog_camera.findViewById(R.id.cam_cancel);
        FrameLayout camera = (FrameLayout) dialog_camera.findViewById(R.id.camera);
        FrameLayout gallery = (FrameLayout) dialog_camera.findViewById(R.id.gallery);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permission.checkStorage()) {
                    openCameraa();
                }
                dialog_camera.dismiss();
            }
        });

        cam_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog_camera.dismiss();
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permission.checkStorage()) {
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    activity.startActivityForResult(photoPickerIntent, GET_IMAGE_GALLARY);
                }
                dialog_camera.dismiss();

            }
        });
        if (!dialog_camera.isShowing()) {
            dialog_camera.show();
        }
    }


    public Uri openCameraa() {

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        Uri fileUri;
        final int sdk = android.os.Build.VERSION.SDK_INT;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        //File file = new File(Environment.getExternalStorageDirectory(), "_" + System.currentTimeMillis() + ".jpg");

        if (sdk > Build.VERSION_CODES.LOLLIPOP) {

            File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File image = null;
            try {
                image = File.createTempFile(String.valueOf(System.currentTimeMillis()), ".jpg", storageDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileUri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", image);

        } else {
            File file = new File(Environment.getExternalStorageDirectory(), "deviceFolder/" + +System.currentTimeMillis() + ".jpg");
            fileUri = Uri.fromFile(file);
        }


        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        activity.startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
        uriiii = fileUri;
        return fileUri;
    }


}
