package com.osvit.biz.frontpage.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.fragment.BaseFragment;
import com.osvit.biz.frontpage.main.activity.MainActivity;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class LoginFragment extends BaseFragment{


    private LoginButton mLoginButton;

    private CallbackManager mCallbackManager;




    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {

        @Override
        public void onSuccess(LoginResult loginResult) {

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

        }


        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }


    };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mLoginButton = (LoginButton) layoutView.findViewById(R.id.login_button);


        mLoginButton.setReadPermissions("user_friends","read_stream", "public_profile", "user_likes","user_posts");
        mLoginButton.setFragment(this);
        mLoginButton.registerCallback(mCallbackManager, mCallback);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }





    }

