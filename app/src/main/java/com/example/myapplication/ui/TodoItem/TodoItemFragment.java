package com.example.myapplication.ui.TodoItem;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Data.TodoItem;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentTodoItemBinding;

import org.w3c.dom.Text;

import java.util.Calendar;

public class TodoItemFragment extends Fragment {

        private FragmentTodoItemBinding binding;
        private int mYear, mMonth, mDay; // 선택된 년, 월, 일을 저장하기 위한 변수


        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {

            TodoItemViewModel viewModel =
                    new ViewModelProvider(this).get(TodoItemViewModel.class);
            binding = FragmentTodoItemBinding.inflate(inflater, container, false);
            View root = binding.getRoot();
            final TextView    todoItemTitle       = binding.editTextTitle;
            final TextView    todoItemDescription = binding.editTextDescription;
            final ImageButton startDateButton     = binding.buttonSelectStartDate;
            final ImageButton endDateButton       = binding.buttonSelectEndDate;
            final Button      buttonAddTask       = binding.buttonAddTask;


            viewModel.getText().observe(getViewLifecycleOwner(), todoItemTitle::setText);
            viewModel.getText().observe(getViewLifecycleOwner(), todoItemDescription::setText);

            startDateButton.setOnClickListener(v -> showDatePickerDialog("isStartDate"));
            endDateButton.setOnClickListener(v -> showDatePickerDialog("isEndDate"));
            buttonAddTask.setOnClickListener(v -> {
                TodoItem newItem = new TodoItem();
                newItem.setSubject(todoItemTitle.getText().toString());
                newItem.setContent(todoItemDescription.getText().toString());
                String startDate = binding.editTextStartDate.getText().toString();
                String endDate = binding.editTextEndDate.getText().toString();
                newItem.setStartDate(startDate);
                newItem.setEndDate(endDate);

                viewModel.addTodoItem(newItem);
            });

            return root;
        }


        private void showDatePickerDialog(String flagStr) {
            // 현재 날짜 가져오기
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                    (view, year, monthOfYear, dayOfMonth) -> {
                        String selectedDate = year + "-" +  (monthOfYear + 1) + "-" + dayOfMonth;
                        EditText editTextDate = null;

                        if (flagStr.equals("isStartDate")) {
                            editTextDate = binding.editTextStartDate;
                        };

                        if (flagStr.equals("isEndDate")) {
                            editTextDate = binding.editTextEndDate;
                        };

                        editTextDate.setText(selectedDate);

                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }



        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
}