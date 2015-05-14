package com.osvit.biz.frontpage.main.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.main.data.model.CommentModel;
import com.osvit.biz.frontpage.main.data.model.CommentModelWrapper;
import com.osvit.biz.frontpage.main.data.model.DataModel;
import com.osvit.biz.frontpage.main.data.model.LikesModel;
import com.osvit.biz.frontpage.main.data.model.LikesModelWrapper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DataModelAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<DataModel> mDataModel = new ArrayList<>();



    public DataModelAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setPosts(@NonNull List<DataModel> posts) {
        mDataModel.clear();
        mDataModel.addAll(posts);
        notifyDataSetChanged();
    }




    @Override
    public int getCount() {
        return mDataModel.size();

    }

    @Override
    public DataModel getItem(int position) {
        return mDataModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;



        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_post, parent, false);
            holder = new ViewHolder();



            holder.mTitleTextView = (TextView) convertView.findViewById(R.id.content_title);
            holder.mMessageTextView = (TextView) convertView.findViewById(R.id.message);
            holder.mPostImageView = (ImageView) convertView.findViewById(R.id.post_image_view);
            holder.mLikesTextView = (TextView) convertView.findViewById(R.id.likes);
            holder.mCommentTextView = (TextView) convertView.findViewById(R.id.comments);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        DataModel item = getItem(position);
        holder.mTitleTextView.setText(item.getFrom().getName());
        holder.mMessageTextView.setText(item.getMessage());






        String picture = item.getPicture();
        if (!TextUtils.isEmpty(picture)) {
            Picasso.with(mContext).load(picture).into(holder.mPostImageView);
        }

        LikesModelWrapper likes = item.getLikes();
        if (likes != null) {
            List<LikesModel> likesList = likes.getLikes();
            if (likesList != null) {
                holder.mLikesTextView.setText(String.valueOf(likesList.size()));
            }
        }

        CommentModelWrapper comments = item.getComments();
        if (comments != null) {
            List<CommentModel> commentList = comments.getComment();
            if (commentList != null) {
                holder.mCommentTextView.setText(String.valueOf(commentList.size()));
            }
        }


        return convertView;
    }

    private static class ViewHolder {
        private TextView mTitleTextView;
        private TextView mMessageTextView;
        private TextView mLikesTextView;
        private TextView mCommentTextView;
        private ImageView mPostImageView;

    }
}
