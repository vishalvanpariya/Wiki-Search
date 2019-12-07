package com.vishal.wikisearch.models;

import com.google.gson.annotations.SerializedName;

public class Continue {
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
