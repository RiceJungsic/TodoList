package com.example.myapplication.ui.TodoItem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.TodoItem;
import com.example.myapplication.ui.TodoItemRepository;

public class TodoItemViewModel extends ViewModel {

    private final MutableLiveData<String> mTitleText;
    private TodoItemRepository repository;

    public TodoItemViewModel() {
        mTitleText = new MutableLiveData<>();
        mTitleText.setValue("뷰모델로 세팅");
    }


    public LiveData<String> getText() {
        return mTitleText;
    }

    public void addTodoItem(TodoItem item) {
        repository.addTodoItem(item);
    }
}