package com.androidbootcamp;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidbootcamp.util.CameraUtility;

/**
 * Created by jhansirk on 1/15/16.
 */
public class AccountsFragment extends Fragment {

    private View view;
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 12;
    private ImageView profilePic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_accounts, null);
        init();
        return view;
    }

    private void init() {
        TextView welcomeTextView = (TextView) view.findViewById(R.id.welcomeTextView);
        profilePic = (ImageView) view.findViewById(R.id.profilePic);
        profilePic.setOnClickListener(new ProfilePicClickListener());
    }

    private String getWelcomeText() {
        String userName = getActivity().getIntent().getStringExtra(HomeActivity.UserName);
        return getString(R.string.welcome) + " " + userName;
    }

    public void setImageBitmap(Bitmap bitmap) {
        profilePic.setImageBitmap(bitmap);
    }

    private class ProfilePicClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            captureImageFromCamera();
        }
    }

    private void captureImageFromCamera() {
        CameraUtility.captureImage(getActivity(), CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

}
