package org.writing.jumpstart.jumpstart2017;

public class Video {
    private String title;
    private String description;
    private String url;

    public Video() {}

    public Video(String title, String desc, String url) {
        this.title = title;
        this.description = desc;
        this.url = url;

    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
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
}
