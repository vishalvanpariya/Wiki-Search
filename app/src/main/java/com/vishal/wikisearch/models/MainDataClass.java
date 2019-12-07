package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

public class MainDataClass {
    @SerializedName("batchcomplete")
    boolean batchcomplete;

    @SerializedName("continue")
    Continue aContinue;
}

class Query{
    @SerializedName("pages")
    List<Page> pages;
}

class Continue{
    @SerializedName("gpsoffset")
    int gpsoffset;

    @SerializedName("continue")
    String continue1;
}

class Page{
    @SerializedName("pageid")
    int pageid;

    @SerializedName("ns")
    int ns;

    @SerializedName("title")
    String title;

    @SerializedName("index")
    String index;

    @SerializedName("thumbnail")
    Thumbnail thumbnail;

    @SerializedName("terms")
    Terms terms;
}


class Thumbnail{
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

class Terms{
    @SerializedName("description")
    List<String> description;
}
