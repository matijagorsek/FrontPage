package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DataModelWrapper implements Parcelable{

    private List<DataModel> data;


    public List<DataModel> getPosts() {
        return data;
    }

    protected DataModelWrapper(Parcel in) {
        if (in.readByte() == 0x01) {
            data = new ArrayList<DataModel>();
            in.readList(data, DataModel.class.getClassLoader());
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
    public static final Parcelable.Creator<DataModelWrapper> CREATOR = new Parcelable.Creator<DataModelWrapper>() {
        @Override
        public DataModelWrapper createFromParcel(Parcel in) {
            return new DataModelWrapper(in);
        }

        @Override
        public DataModelWrapper[] newArray(int size) {
            return new DataModelWrapper[size];
        }
    };

}
