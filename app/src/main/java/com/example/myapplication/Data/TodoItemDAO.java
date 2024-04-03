package com.example.myapplication.Data;

import androidx.room.*;

import java.util.List;

@Dao
public interface TodoItemDAO {
    @Query("SELECT * FROM todoItem")
    List<TodoItem> getAll();

    @Insert
    void insert(TodoItem todoItem);

    @Update
    void update(TodoItem todoItem);

    @Delete
    void delete(TodoItem todoItem);
}
