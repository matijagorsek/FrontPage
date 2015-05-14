package com.osvit.biz.frontpage.details.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.base.fragment.BaseFragment;

import com.osvit.biz.frontpage.details.adapter.DetailsAdapter;
import com.osvit.biz.frontpage.main.data.adapter.DataModelAdapter;
import com.osvit.biz.frontpage.main.data.model.CommentModel;
import com.osvit.biz.frontpage.main.data.model.CommentModelWrapper;
import com.osvit.biz.frontpage.main.data.model.DataModel;
import com.osvit.biz.frontpage.main.fragment.MainFragment;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DetailsFragment extends BaseFragment {

    private static final String DETAILS_KEY = "details_key";


    private ListView mCommentListView;
    private DetailsAdapter mDetailsAdapter;
    private TextView mMessageTextView;
    private TextView mContentTitle;
    private ImageView mPostImageView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);

    }
    @Override
    protected void prepareUI(@NonNull View layoutView) {

        DataModel model = getActivity().getIntent().getExtras().getParcelable(DETAILS_KEY);

        mDetailsAdapter = new DetailsAdapter(getActivity());
        mCommentListView = (ListView) layoutView.findViewById(R.id.comments);
        mCommentListView.setAdapter(mDetailsAdapter);


        mDetailsAdapter.setComments( model.getComments().getComment());

        String picture = model.getPicture();
        if (!TextUtils.isEmpty(picture)) {

            mPostImageView = (ImageView) layoutView.findViewById(R.id.post_image_view);
            Picasso.with(getActivity()).load(model.getPicture()).into(mPostImageView);

        }


        mMessageTextView = (TextView) layoutView.findViewById(R.id.message);
        mMessageTextView.setText(model.getMessage());

        mContentTitle = (TextView) layoutView.findViewById(R.id.content_title);
        mContentTitle.setText(model.getFrom().getName());



    }
}
