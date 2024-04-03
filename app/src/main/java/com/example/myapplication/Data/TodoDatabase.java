package com.example.myapplication.Data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TodoItem.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase INSTANCE = null;
    public abstract TodoItemDAO todoItemDao();

    public static TodoDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    TodoDatabase.class, "todoItem.db").build();
        }
        return INSTANCE;
    }

//    public static void destroyInstance() {
//        INSTANCE = null;
//    }


}