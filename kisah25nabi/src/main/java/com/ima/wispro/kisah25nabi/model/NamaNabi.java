package com.ima.wispro.kisah25nabi.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by r0adkll on 1/11/15.
 */
public class NamaNabi implements Parcelable{
    public String name;
    public String year;
    public int sdk_int;
    public String description;
    public int version;
    public String image_url;
    public String icon_url;

    public NamaNabi(){}

    private NamaNabi(Parcel in){
        name = in.readString();
        year = in.readString();
        sdk_int = in.readInt();
        description = in.readString();
        version = in.readInt();
        image_url = in.readString();
        icon_url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(year);
        dest.writeInt(sdk_int);
        dest.writeString(description);
        dest.writeInt(version);
        dest.writeString(image_url);
        dest.writeString(icon_url);
    }

    public static final Creator<NamaNabi> CREATOR = new Creator<NamaNabi>() {
        @Override
        public NamaNabi createFromParcel(Parcel source) {
            return new NamaNabi(source);
        }

        @Override
        public NamaNabi[] newArray(int size) {
            return new NamaNabi[size];
        }
    };

}
