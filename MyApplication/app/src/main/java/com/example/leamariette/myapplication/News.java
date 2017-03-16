package com.example.leamariette.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by leamariette on 14/03/2017.
 */

class News implements Parcelable {


    private String articletext;
    private String infostext;
    private String category;
    private Date date;
    private int comments;
    private boolean underthelight;

    public News(String articletext, String infostext, String category, boolean underthelight) {
        this.articletext = articletext;
        this.infostext = infostext;
        this.category = category;
        this.underthelight = underthelight;
        this.date = new Date();
        this.comments = 0;
    }


    public String getArticletext() {
        return articletext;
    }

    public void setArticletext(String articletext) {
        this.articletext = articletext;
    }

    public String getInfostext() {
        return infostext;
    }

    public void setInfostext(String infostext) {
        this.infostext = infostext;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public boolean isUnderthelight() {
        return underthelight;
    }

    public void setUnderthelight(boolean underthelight) {
        this.underthelight = underthelight;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.articletext);
        dest.writeString(this.infostext);
        dest.writeString(this.category);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeInt(this.comments);
        dest.writeByte(this.underthelight ? (byte) 1 : (byte) 0);
    }

    protected News(Parcel in) {
        this.articletext = in.readString();
        this.infostext = in.readString();
        this.category = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.comments = in.readInt();
        this.underthelight = in.readByte() != 0;
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
