package com.vishal.wikisearch.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Page.class,
                parentColumns = "pageid",
                childColumns = "parentkey"
        )
})
public class Terms {

    @PrimaryKey
    int parentkey;

    String des;

    public int getParentkey() {
        return parentkey;
    }

    public Terms(){
        if (description!=null) {
            if (description.size() > 0)
                this.des = description.get(0);
        }
    }

    public Terms(int parentkey, List<String> description) {
        this.parentkey = parentkey;
        this.description = description;
        if (description.size()>0)
            this.des=description.get(0);
    }

    public void setParentkey(int parentkey) {
        this.parentkey = parentkey;
    }

    @Ignore
    @SerializedName("description")
    List<String> description;

    @Ignore
    public Terms(List<String> description) {
        this.description = description;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
