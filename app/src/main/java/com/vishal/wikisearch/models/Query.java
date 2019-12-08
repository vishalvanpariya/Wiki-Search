package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

public class Query {
    @SerializedName("pages")
    LinkedList<Page> pages;

    public Query(LinkedList<Page> pages) {
        this.pages = pages;
    }

    public LinkedList<Page> getPages() {
        return pages;
    }

    public void setPages(LinkedList<Page> pages) {
        this.pages = pages;
    }
}
