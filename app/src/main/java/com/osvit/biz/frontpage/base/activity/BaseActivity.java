package com.osvit.biz.frontpage.base.activity;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.osvit.biz.frontpage.base.fragment.BaseFragment;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public abstract class BaseActivity extends ActionBarActivity {

    protected void replaceFragment(int layoutId, @NonNull BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        transaction.commit();
    }


    protected abstract void prepareUi();
}
