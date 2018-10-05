package com.example.genricfunctions;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.genricfunctions.genric_classes.CameraController;
import com.example.genricfunctions.genric_classes.LOGS;
import com.example.genricfunctions.genric_classes.Permission;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

public class MainActivity extends AppCompatActivity {
   public ImageView camImg;
    CameraController cameraController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraController = new CameraController(this);
        camImg = findViewById(R.id.camImg);

        camImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraController.OpenCam();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraController.CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    if (cameraController.uriiii != null && !cameraController.uriiii.equals(Uri.EMPTY) && !cameraController.uriiii.equals("null")) {
                        CropImage.activity(cameraController.uriiii).setOutputCompressQuality(70).start(this);
                        LOGS.system("imageeeee", String.valueOf(cameraController.uriiii.getPath()));
                        //CropImage.activity(cameraController.uriiii).start(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == CameraController.GET_IMAGE_GALLARY) {
            if (resultCode == RESULT_OK) {
                final Uri imageUri = data.getData();
                try {
                    if (imageUri != null && !imageUri.equals(Uri.EMPTY) && !imageUri.equals("null")) {
                        CropImage.activity(imageUri).start(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                final Uri cropImagePath = result.getUri();
                //Uri bitmap= new ImageCompress(ProfileActivity.this).imageCompress(cropImagePath);
                //Toast.makeText(this, ""+cropImagePath.getPath(), Toast.LENGTH_SHORT).show();
                Picasso.get().load(cropImagePath).into(camImg);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Permission.IMAGE_STOREAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                cameraController.OpenCam();
            }
        }
    }
}
