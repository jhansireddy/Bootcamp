package com.androidbootcamp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidbootcamp.util.CameraUtility;

/**
 * Created by jhansirk on 1/15/16.
 */
public class AccountsActivity extends Activity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 12;
    public static String UserName = "USER_NAME";
    private ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        init();
    }

    private void init() {
        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        welcomeTextView.setText(getWelcomeText());
        profilePic = (ImageView) findViewById(R.id.profilePic);
        profilePic.setOnClickListener(new ProfilePicClickListener());
    }

    private String getWelcomeText() {
        String userName = getIntent().getStringExtra(UserName);
        return getString(R.string.welcome) + " " + userName;
    }

    private class ProfilePicClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            captureImageFromCamera();
        }
    }

    private void captureImageFromCamera() {
        CameraUtility.captureImage(this, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = CameraUtility.extractImage(data);
            profilePic.setImageBitmap(bitmap);
        }
    }
}