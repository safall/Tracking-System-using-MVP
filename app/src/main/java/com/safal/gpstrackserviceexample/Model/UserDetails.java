package com.safal.gpstrackserviceexample.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by White Cat on 6/1/2017.
 */

public class UserDetails  implements Parcelable {

    String userName;

    protected UserDetails(Parcel in) {
        userName = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
    }
}
