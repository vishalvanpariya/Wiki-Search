package com.vishal.wikisearch.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;

import java.util.List;

@Dao
public interface TermsTable {
    @Insert
    void insertterms(Terms terms);

    @Query("SELECT * FROM TERMS where parentkey=:id limit 1")
    LiveData<Terms> getterms(int id);
}
