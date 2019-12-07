package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

public class MainDataClass {
    @SerializedName("batchcomplete")
    boolean batchcomplete;

    @SerializedName("continue")
    Continue aContinue;

    public MainDataClass(boolean batchcomplete, Continue aContinue) {
        this.batchcomplete = batchcomplete;
        this.aContinue = aContinue;
    }

    public boolean isBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(boolean batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getaContinue() {
        return aContinue;
    }

    public void setaContinue(Continue aContinue) {
        this.aContinue = aContinue;
    }
}

class Query{
    @SerializedName("pages")
    List<Page> pages;

    public Query(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}

class Continue{
    @SerializedName("gpsoffset")
    int gpsoffset;

    @SerializedName("continue")
    String continue1;

    public Continue(int gpsoffset, String continue1) {
        this.gpsoffset = gpsoffset;
        this.continue1 = continue1;
    }

    public int getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(int gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getContinue1() {
        return continue1;
    }

    public void setContinue1(String continue1) {
        this.continue1 = continue1;
    }
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

    public Page(int pageid, int ns, String title, String index, Thumbnail thumbnail, Terms terms) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.index = index;
        this.thumbnail = thumbnail;
        this.terms = terms;
    }

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }
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
