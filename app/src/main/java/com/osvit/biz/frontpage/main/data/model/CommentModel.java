package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class CommentModel implements Parcelable {



    private String id;
    private String name;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CommentModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        message = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(message);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CommentModel> CREATOR = new Parcelable.Creator<CommentModel>() {
        @Override
        public CommentModel createFromParcel(Parcel in) {
            return new CommentModel(in);
        }

        @Override
        public CommentModel[] newArray(int size) {
            return new CommentModel[size];
        }
    };
}
