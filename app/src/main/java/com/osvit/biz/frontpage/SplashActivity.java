package com.osvit.biz.frontpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.osvit.biz.frontpage.base.activity.BaseActivity;
import com.osvit.biz.frontpage.login.activity.LoginActivity;
import com.osvit.biz.frontpage.main.activity.MainActivity;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */


public class SplashActivity extends BaseActivity {

    private final int SPLASH_DURATION = 3000;

    private final Handler mHandler = new Handler();

    private Profile profile;

    private AccessToken fbToken;



    private final Runnable mNextActivityRunnable = new Runnable() {
        @Override
        public void run() {
            startNextActivity();
        }
    };

    //Ui widgets

    private ImageView mLogoImageView;





    private void startNextActivity() {


        if( fbToken != null){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }else {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        FacebookSdk.sdkInitialize(this.getApplicationContext());

        setContentView(R.layout.activity_splash);


        mLogoImageView = (ImageView) findViewById(R.id.front_page_logo);

    }

    @Override
    protected void onStart() {
        super.onStart();
        fbToken = AccessToken.getCurrentAccessToken();
        mHandler.postDelayed(mNextActivityRunnable, SPLASH_DURATION);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mNextActivityRunnable);
    }


    @Override
    protected void prepareUi() {

    }
}

