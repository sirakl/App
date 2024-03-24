package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication4.entity.Person;
import com.example.myapplication4.store.DiskPersonStore;
import com.example.myapplication4.store.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private MyAdapter adapter;
    private DiskPersonStore personStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personStore = new DiskPersonStore(this);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(this::onAddButtonClick);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Person> allPeople = personStore.getAll();
        adapter = new MyAdapter(allPeople, id -> {
                personStore.removeRecord(id);
                List<Person> updatedList = personStore.getAll();
                adapter.setDataList(updatedList);
            });


        recyclerView.setAdapter(adapter);
        Button filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });
    }
    public void onAddButtonClick(View view) {
        Intent intent = new Intent(this, AddPersonActivityActivity.class);
        startActivity(intent);
    }
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Person> dataList = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(dataList, null);
        recyclerView.setAdapter(adapter);
    }
    private void showFilterDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Выберите тип")
                .setItems(R.array.filter_options, (dialog, which) -> {
                    String[] filters = getResources().getStringArray(R.array.filter_options);
                    String selectedFilter = filters[which];
                    // Действия в зависимости от выбранного фильтра
                    switch (selectedFilter) {
                        case "Студенты":
                            // Фильтровать только студентов
                            adapter.setDataList(personStore.getStudents());
                            Toast.makeText(this, "Выбраны студенты", Toast.LENGTH_SHORT).show();
                            break;
                        case "Учителя":
                            // Фильтровать только учителей
                            adapter.setDataList(personStore.getTeachers());
                            Toast.makeText(this, "Выбраны учителя", Toast.LENGTH_SHORT).show();
                            break;
                        case "Все":
                            // Показать всех студентов и учителей
                            adapter.setDataList(personStore.getAll());
                            Toast.makeText(this, "Выбраны все", Toast.LENGTH_SHORT).show();
                            break;
                    }
                })
                .create()
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Person> allPeople = personStore.getAll();
        adapter.setDataList(allPeople);
    }




}