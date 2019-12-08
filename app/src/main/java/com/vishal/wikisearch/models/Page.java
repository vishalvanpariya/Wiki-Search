package com.vishal.wikisearch.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Page {


    @PrimaryKey
    @SerializedName("pageid")
    int pageid;

    @SerializedName("ns")
    int ns;

    @SerializedName("title")
    String title;

    @SerializedName("index")
    String index;

    @Ignore
    @SerializedName("thumbnail")
    Thumbnail thumbnail=null;

    @Ignore
    @SerializedName("terms")
    Terms terms;


    public Page(int pageid, int ns, String title, String index) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.index = index;
    }

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
