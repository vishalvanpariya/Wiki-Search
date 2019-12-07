package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainDataClass {
    @SerializedName("batchcomplete")
    boolean batchcomplete;

    @SerializedName("continue")
    Continue aContinue;

    @SerializedName("query")
    Query query;

    public MainDataClass(boolean batchcomplete, Continue aContinue, Query query) {
        this.batchcomplete = batchcomplete;
        this.aContinue = aContinue;
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
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

