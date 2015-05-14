package com.osvit.biz.frontpage.base.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public abstract class BaseFragment extends Fragment {



    protected abstract void prepareUI(@NonNull View layoutView);

    protected void replaceFragment(int layoutId, @NonNull BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.commit();
    }
}
