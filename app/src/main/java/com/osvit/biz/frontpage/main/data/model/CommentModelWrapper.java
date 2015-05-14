package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class CommentModelWrapper implements Parcelable {

    private static final String DETAILS_KEY = "details_key";

    private List<CommentModel> data;

    public List<CommentModel> getComment() {
        return data;
    }

    public CommentModelWrapper(Parcel in) {
        if (in.readByte() == 0x01) {
            data = new ArrayList<CommentModel>();
            in.readList(data, CommentModel.class.getClassLoader());
        } else {
            data = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (data == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(data);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CommentModelWrapper> CREATOR = new Parcelable.Creator<CommentModelWrapper>() {
        @Override
        public CommentModelWrapper createFromParcel(Parcel in) {
            return new CommentModelWrapper(in);
        }

        @Override
        public CommentModelWrapper[] newArray(int size) {
            return new CommentModelWrapper[size];
        }
    };
}
