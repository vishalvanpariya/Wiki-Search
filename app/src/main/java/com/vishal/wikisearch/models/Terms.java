package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Terms {
    @SerializedName("description")
    List<String> description;

    public Terms(List<String> description) {
        this.description = description;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
