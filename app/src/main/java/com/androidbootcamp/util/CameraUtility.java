package com.androidbootcamp.util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

/**
 * Created by jhansirk on 1/15/16.
 */
public class CameraUtility {

    public static void captureImage(Activity activity, int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    public static Bitmap extractImage(Intent intent) {
        Bundle bundle = intent.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");
        return bitmap;
    }

}