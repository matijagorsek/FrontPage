package com.osvit.biz.frontpage.details.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.osvit.biz.frontpage.R;
import com.osvit.biz.frontpage.main.data.model.CommentModel;
import com.osvit.biz.frontpage.main.data.model.CommentModelWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DetailsAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<CommentModel> mCommentModel = new ArrayList<>();

    public DetailsAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setComments(@NonNull List<CommentModel> comments) {
        mCommentModel.clear();
        mCommentModel.addAll(comments);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCommentModel.size();
    }

    @Override
    public CommentModel getItem(int position) {
        return mCommentModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_comment, parent, false);
            holder = new ViewHolder();
            holder.mNameTextView = (TextView) convertView.findViewById(R.id.content_name);
            holder.mMessageTextView = (TextView) convertView.findViewById(R.id.content_message);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CommentModel item = getItem(position);

        holder.mNameTextView.setText(item.getName());
        holder.mMessageTextView.setText(item.getMessage());

        return convertView;
    }

    private static class ViewHolder {
        private TextView mNameTextView;
        private TextView mMessageTextView;
    }
}