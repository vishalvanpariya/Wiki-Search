package com.vishal.wikisearch.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Page.class,
                parentColumns = "pageid",
                childColumns = "parentid"
        )
})
public class Thumbnail {

    @PrimaryKey
    int parentid;

    public Thumbnail(int parentid, String source, int width, int height) {
        this.parentid = parentid;
        this.source = source;
        this.width = width;
        this.height = height;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    @SerializedName("source")
    String source;

    @SerializedName("width")
    int width;

    @SerializedName("height")
    int height;

    @Ignore
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
