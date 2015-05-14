package com.osvit.biz.frontpage.main.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by IvanAzenic & Matija Goršek on 16.4.2015..
 */
public class DataModel implements Parcelable{

    private String id;
    private FromModel from;
    private String message;
    private String picture;
    private String postTime;


    private LikesModelWrapper likes;


    private CommentModelWrapper comments;



    public CommentModelWrapper getComments() {
        return comments;
    }

    public String getId() {
        return id;
    }


    public FromModel getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public String getPicture() {
        return picture;
    }

    public String getPostTime() {
        return postTime;
    }

    public LikesModelWrapper getLikes() {
        return likes;
    }

    public DataModel(Parcel in) {
        id = in.readString();
        from = (FromModel) in.readValue(FromModel.class.getClassLoader());
        message = in.readString();
        picture = in.readString();
        postTime = in.readString();
        likes = (LikesModelWrapper) in.readValue(LikesModelWrapper.class.getClassLoader());
        comments = (CommentModelWrapper) in.readValue(CommentModelWrapper.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeValue(from);
        dest.writeString(message);
        dest.writeString(picture);
        dest.writeString(postTime);
        dest.writeValue(likes);
        dest.writeValue(comments);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DataModel> CREATOR = new Parcelable.Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {

            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };
}
