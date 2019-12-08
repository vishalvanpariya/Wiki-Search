package com.vishal.wikisearch.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;
import com.vishal.wikisearch.models.Thumbnail;

@Database(entities = {Page.class, Thumbnail.class, Terms.class},version = 1,exportSchema = false)
public abstract class PageDataBase extends RoomDatabase {
    public abstract DBTable gettable();
    public abstract TermsTable gettermtable();
    public abstract ThumbnailTable getThumbnailTable();
    private static volatile PageDataBase INSTANCE;

    public static PageDataBase getDataBase(Context context){
        if (INSTANCE==null){
            synchronized (Database.class){
                if (INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PageDataBase.class, "page-db").build();
                }
            }
        }
        return INSTANCE;
    }
}
