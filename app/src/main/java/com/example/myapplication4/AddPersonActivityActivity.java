package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPersonActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_activity);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        button2.setOnClickListener(this::onAddButtonClick);
        button3.setOnClickListener(this::onAddButtonClick1);
    }
    public void onAddButtonClick(View view) {
        Intent intent = new Intent(this, StudentAddActivity.class);
        startActivity(intent);
    }
    public void onAddButtonClick1(View view) {
        Intent intent = new Intent(this, TeacherAddActivity.class);
        startActivity(intent);
    }
}