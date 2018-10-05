package com.example.genricfunctions.genric_classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayOutputStream;

/*********
 * Class will compress the image
 */

public class ImageCompress {
    public byte[] imageCompress(Uri uri){
        String picturePath=uri.getPath();
        Bitmap thumbnaill = BitmapFactory.decodeFile(picturePath);
        int nh = (int) ( thumbnaill.getHeight() * (512.0 / thumbnaill.getWidth()) );
        Bitmap thumbnail = Bitmap.createScaledBitmap(thumbnaill, 512, nh, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] data = baos.toByteArray();
        return data;
    }
}
