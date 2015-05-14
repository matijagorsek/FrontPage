package com.osvit.biz.frontpage.details.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.activity.BaseActivity;
import com.osvit.biz.frontpage.details.fragment.DetailsFragment;
import com.osvit.biz.frontpage.main.data.model.CommentModel;
import com.osvit.biz.frontpage.main.data.model.CommentModelWrapper;
import com.osvit.biz.frontpage.main.data.model.DataModel;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DetailsActivity extends BaseActivity {

    private static final String DETAILS_KEY = "details_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


          replaceFragment(R.id.fragment_container,new DetailsFragment(), false);

    }




    @Override
    protected void prepareUi() {


    }


}
