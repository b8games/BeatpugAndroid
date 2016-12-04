package com.b8games.beatpug.activities;

/**
 * Created by monster on 1.12.2016.
 */

public class MyData {

    private int id;
    private String description,image_link,videolink;

    public MyData(int id, String description, String image_link, String videolink) {
        this.id = id;
        this.description = description;
        this.image_link = image_link;
        this.videolink = videolink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
    public String getvideo_link() {
        return videolink;
    }

    public void setvideolink(String videolink) {
        this.videolink = videolink;
    }
}