package com.androidbootcamp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.androidbootcamp.util.CameraUtility;

/**
 * Created by jhansirk on 1/15/16.
 */
public class HomeActivity extends Activity {

    public static String UserName ="userName";
    private AccountsFragment accountsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        if(getFragmentManager().findFragmentById(R.id.accountsFragment)!=null)
//        {
//            accountsFragment = (AccountsFragment) getFragmentManager().findFragmentById(R.id.accountsFragment);
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AccountsFragment.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = CameraUtility.extractImage(data);
            if(accountsFragment!=null)
            {
                accountsFragment.setImageBitmap(bitmap);
            }
        }
    }
}