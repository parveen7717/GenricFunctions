package com.example.genricfunctions.genric_classes;

import android.net.Uri;
import android.widget.ImageView;

import com.example.genricfunctions.R;
import com.squareup.picasso.Picasso;

/****************
 * This class used for load images from Picasso
 */

public class ImageLoad {
    public static void imageLoad(String url, ImageView imageView){
        Uri imageUri = Uri.parse(url);
        if(imageUri!=null) {
            Picasso.get().load(imageUri).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(imageView);
        }
    }
}
