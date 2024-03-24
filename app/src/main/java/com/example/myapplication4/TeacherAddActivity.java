package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication4.entity.Teacher;
import com.example.myapplication4.store.DiskPersonStore;
import com.example.myapplication4.store.PersonStore;

public class TeacherAddActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText specialtyEditText;
    private Button saveButton;
    private PersonStore diskPersonStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_add);

        nameEditText = findViewById(R.id.editTextText);
        specialtyEditText = findViewById(R.id.editTextTextMultiLine);
        saveButton = findViewById(R.id.button4);
        diskPersonStore=new DiskPersonStore(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String specialty = specialtyEditText.getText().toString();

                if(name.isEmpty() || specialty.isEmpty()){
                    Toast.makeText(TeacherAddActivity.this,"Введіть ім'я і спеціальність",Toast.LENGTH_SHORT).show();
                    return;
                }

                diskPersonStore.addTeacher(name,"",specialty);
                Toast.makeText(TeacherAddActivity.this,"Вчителя додано успішно", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
    }
}