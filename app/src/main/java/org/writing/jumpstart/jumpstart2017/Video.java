package org.writing.jumpstart.jumpstart2017;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {
    private String title;
    private String description;
    private String url;
    private String type;
    private String html;
    private static Parcelable.Creator<Video> CREATOR;
    public Video() {}

    public Video(String desc, String title, String html, String url, String type) {

        this.description = desc;
        this.title = title;
        this.html = html;
        this.url = url;
        this.type = type;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return url;
    }

    public void setDesc(String description) {
        this.description = description;
    }
    public String getDescription(){return description;}
    public void setURL(String url){
        this.url = url;
    }
    public String getType() { return type;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
