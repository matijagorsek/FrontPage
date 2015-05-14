package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */


public class LikesModel implements Parcelable{


    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected LikesModel(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LikesModel> CREATOR = new Parcelable.Creator<LikesModel>() {
        @Override
        public LikesModel createFromParcel(Parcel in) {
            return new LikesModel(in);
        }

        @Override
        public LikesModel[] newArray(int size) {
            return new LikesModel[size];
        }
    };
}

