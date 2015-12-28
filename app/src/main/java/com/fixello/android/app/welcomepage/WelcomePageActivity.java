package com.fixello.android.app.welcomepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.fixello.android.app.R;
import com.fixello.android.app.ui.login.LoginActivity;

public class WelcomePageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO: Use Injected Application Context
        boolean alreadyOpened = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(getString(R.string.already_accepted_user_key), false);
        if (alreadyOpened) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            startActivity(intent);
        }
    }
}
