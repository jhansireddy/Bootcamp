package com.androidbootcamp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new LoginButtonClickListener());
        findViewById(R.id.forgotPassword).setOnClickListener(new ForgotPasswordClickListener());
    }

    private void openForgotPasswordPage() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    private class LoginButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String userName = ((EditText) findViewById(R.id.userName)).getText().toString();
            String password = ((EditText) findViewById(R.id.password)).getText().toString();
            Log.d("", "User name:" + userName + "password:" + password);
            startAccountsActivity(userName);
        }
    }

    private void startAccountsActivity(String userName) {
        Intent intent = new Intent(this, AccountsActivity.class);
        intent.putExtra(AccountsActivity.UserName, userName);
        startActivity(intent);
    }

    private class ForgotPasswordClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            openForgotPasswordPage();
        }
    }
}