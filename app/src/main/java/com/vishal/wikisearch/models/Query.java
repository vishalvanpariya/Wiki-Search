package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query {
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
