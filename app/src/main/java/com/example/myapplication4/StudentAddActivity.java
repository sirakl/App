package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication4.entity.Student;
import com.example.myapplication4.store.DiskPersonStore;
import com.example.myapplication4.store.MemoryPersonStore;
import com.example.myapplication4.store.PersonStore;

public class StudentAddActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText classEditText;
    private Button saveButton;
    private PersonStore memoryPersonStore;
    private PersonStore diskPersonStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add);

        nameEditText = findViewById(R.id.editTextText);
        classEditText = findViewById(R.id.editTextTextMultiLine);
        saveButton = findViewById(R.id.button4);

        memoryPersonStore = new MemoryPersonStore();
        diskPersonStore = new DiskPersonStore(this);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString().trim();
                String classText = classEditText.getText().toString().trim();


                if (name.isEmpty() || classText.isEmpty()) {
                    Toast.makeText(StudentAddActivity.this, "Введите имя и класс", Toast.LENGTH_SHORT).show();
                    return;
                }
                memoryPersonStore.addStudent(name, "", Integer.parseInt(classText));
                diskPersonStore.addStudent(name, "", Integer.parseInt(classText));

                Toast.makeText(StudentAddActivity.this, "Студент успешно добавлен", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}