package com.osvit.biz.frontpage.login.activity;

import android.os.Bundle;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.activity.BaseActivity;
import com.osvit.biz.frontpage.login.fragment.LoginFragment;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class LoginActivity extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        replaceFragment(R.id.fragment_container, new LoginFragment(), false);
    }

    @Override
    protected void prepareUi() {

    }
}
