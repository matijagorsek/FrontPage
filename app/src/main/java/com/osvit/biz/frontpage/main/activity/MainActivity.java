package com.osvit.biz.frontpage.main.activity;

import android.os.Bundle;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.activity.BaseActivity;
import com.osvit.biz.frontpage.main.fragment.MainFragment;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class MainActivity extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.fragment_container, new MainFragment(), false);
    }

    @Override
    protected void prepareUi() {

    }
}
