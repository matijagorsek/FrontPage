package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class LikesModelWrapper implements Parcelable{

    private List<LikesModel> data;

    public List<LikesModel> getLikes() {
        return data;
    }

    protected LikesModelWrapper(Parcel in) {
        if (in.readByte() == 0x01) {
            data = new ArrayList<LikesModel>();
            in.readList(data, LikesModel.class.getClassLoader());
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
    public static final Parcelable.Creator<LikesModelWrapper> CREATOR = new Parcelable.Creator<LikesModelWrapper>() {
        @Override
        public LikesModelWrapper createFromParcel(Parcel in) {
            return new LikesModelWrapper(in);
        }

        @Override
        public LikesModelWrapper[] newArray(int size) {
            return new LikesModelWrapper[size];
        }
    };
}
