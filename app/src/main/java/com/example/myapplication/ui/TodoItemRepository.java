package com.example.myapplication.ui;
import com.example.myapplication.Data.TodoItem;
import com.example.myapplication.Data.TodoItemDAO;

import java.util.List;
import java.util.ArrayList;

public class TodoItemRepository {
    private List<TodoItem> todoItems;
    private TodoItemDAO todoItemDAO;

    public TodoItemRepository() {
        this.todoItems = new ArrayList<>();
    }

    public List<TodoItem> getAllTodoItems() {
        return todoItems;
    }

    public TodoItem getTodoItemById(int id) {
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void addTodoItem(TodoItem item) {
        todoItemDAO.insert(item);
    }

    public void deleteTodoItem(int id) {
        TodoItem itemToRemove = null;
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            todoItems.remove(itemToRemove);
        }
    }

    public void updateTodoItem(TodoItem updatedItem) {
        for (int i = 0; i < todoItems.size(); i++) {
            TodoItem item = todoItems.get(i);
            if (item.getId() == updatedItem.getId()) {
                todoItems.set(i, updatedItem);
                break;
            }
        }
    }
}