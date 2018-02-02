package com.hpzl.businessedition.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author admin
 * @date 2018/1/31
 */

public class RoomTypeModel {



    public int code;
    public String message;
    public List<ContentBean> content;

    public static class ContentBean implements Parcelable {
        /**
         * id : 82
         * name : 小包
         * book_price : 1.00
         * mans : 6
         */

        public String id;
        public String name;
        public int book_price;
        public String mans;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeInt(this.book_price);
            dest.writeString(this.mans);
        }

        public ContentBean() {
        }

        protected ContentBean(Parcel in) {
            this.id = in.readString();
            this.name = in.readString();
            this.book_price = in.readInt();
            this.mans = in.readString();
        }

        public static final Parcelable.Creator<ContentBean> CREATOR = new Parcelable.Creator<ContentBean>() {
            @Override
            public ContentBean createFromParcel(Parcel source) {
                return new ContentBean(source);
            }

            @Override
            public ContentBean[] newArray(int size) {
                return new ContentBean[size];
            }
        };
    }
}
