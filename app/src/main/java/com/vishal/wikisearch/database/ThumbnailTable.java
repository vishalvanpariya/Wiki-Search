package com.vishal.wikisearch.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vishal.wikisearch.models.Thumbnail;

@Dao
public interface ThumbnailTable {
    @Insert
    void insertthumbnil(Thumbnail thumbnail);

    @Query("select * from Thumbnail where parentid=:id limit 1")
    LiveData<Thumbnail> getThumbnail(int id);
}
