package com.osvit.biz.frontpage.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.osvit.biz.frontpage.details.activity.DetailsActivity;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.fragment.BaseFragment;
import com.osvit.biz.frontpage.main.data.model.CommentModel;
import com.osvit.biz.frontpage.main.data.adapter.DataModelAdapter;
import com.osvit.biz.frontpage.main.data.model.CommentModelWrapper;
import com.osvit.biz.frontpage.main.data.model.DataModel;
import com.osvit.biz.frontpage.main.data.model.DataModelWrapper;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class MainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    public static final String DETAILS_KEY = "details_key";

    private ListView mPostsListView;
    private DataModelAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
       handleDetailsOnClick();



    }



    @Override
    protected void prepareUI(@NonNull View layoutView) {

        mSwipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.activity_main_swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(this);



        mPostsListView = (ListView) layoutView.findViewById(R.id.adapter_view);

        mAdapter = new DataModelAdapter(getActivity());
        mPostsListView.setAdapter(mAdapter);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareData();
    }



    public void prepareData() {
        GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "me/home",
                new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {
                String jsonString = graphResponse.getRawResponse();
                DataModelWrapper wrapper = new Gson().fromJson(jsonString, DataModelWrapper.class);
               mAdapter.setPosts(wrapper.getPosts());

            }
        });

        request.executeAsync();
    }


    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                prepareData();
                mPostsListView.invalidateViews();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);


    }

    private void handleDetailsOnClick(){

        mPostsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel model = mAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(DETAILS_KEY, model);
                startActivity(intent);

            }
        });
    }

}





