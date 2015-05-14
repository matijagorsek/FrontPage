package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class FromModel implements Parcelable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected FromModel(Parcel in) {
        id = in.readLong();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FromModel> CREATOR = new Parcelable.Creator<FromModel>() {
        @Override
        public FromModel createFromParcel(Parcel in) {
            return new FromModel(in);
        }

        @Override
        public FromModel[] newArray(int size) {
            return new FromModel[size];
        }
    };
}
