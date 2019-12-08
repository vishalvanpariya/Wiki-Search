package com.vishal.wikisearch.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vishal.wikisearch.models.Page;

import java.util.List;

@Dao
public interface DBTable {
    @Insert
    void insertdata(Page page);

    @Query("SELECT * FROM Page")
    LiveData<List<Page>> getdata();


}
