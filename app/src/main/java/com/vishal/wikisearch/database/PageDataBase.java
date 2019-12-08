package com.vishal.wikisearch.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class PageDataBase extends RoomDatabase {
    public abstract DBTable getdata();
    private static volatile PageDataBase INSTANCE;

    static PageDataBase getDataBase(Context context){
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
