package com.example.myapplication4.store;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication4.R;

public class FilterDialogFragment extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите тип")
                .setItems(R.array.filter_options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] filters = getResources().getStringArray(R.array.filter_options);
                        String selectedFilter = filters[which];
                        // Действия в зависимости от выбранного фильтра
                        switch (selectedFilter) {
                            case "Студенты":
                                // Фильтровать только студентов
                                Toast.makeText(getActivity(), "Выбраны студенты", Toast.LENGTH_SHORT).show();
                                break;
                            case "Учителя":
                                // Фильтровать только учителей
                                Toast.makeText(getActivity(), "Выбраны учителя", Toast.LENGTH_SHORT).show();
                                break;
                            case "Все":
                                // Показать всех студентов и учителей
                                Toast.makeText(getActivity(), "Выбраны все", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
        return builder.create();
    }
}

