package com.example.task51;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyDataModel implements Serializable{

    String title, description, imageUrl, content;
    int image;

    ArrayList<RelatedDataModel> relatedStories;

    public MyDataModel(String title, String description, String imageUrl, String content, ArrayList<RelatedDataModel> relatedStories) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.relatedStories = relatedStories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<RelatedDataModel> getRelatedStories() {
        return relatedStories;
    }
}
