package com.yuanyang.lession19;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yuanyang on 16/8/19.
 */
public class Message implements Parcelable {

    private String content;

    public String getContent() {
        return content;
    }

    public Message() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Message(Parcel in) {
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content);
    }
}
