package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

public class Thumbnail {
    @SerializedName("source")
    String source;

    @SerializedName("width")
    int width;

    @SerializedName("height")
    int height;

    public Thumbnail(String source, int width, int height) {
        this.source = source;
        this.width = width;
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
