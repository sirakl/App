package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication4.store.DiskPersonStore;
import com.example.myapplication4.store.PersonStore;

public class StudentAddActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText lastEditText;
    private EditText classEditText;
    private Button saveButton;
    private PersonStore diskPersonStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add);

        nameEditText = findViewById(R.id.editTextText);
        classEditText = findViewById(R.id.editTextTextMultiLine);
        lastEditText=findViewById(R.id.sawtooth);
        saveButton = findViewById(R.id.button4);

        diskPersonStore = new DiskPersonStore(this);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString().trim();
                String classText = classEditText.getText().toString().trim();
                String lastName =lastEditText.getText().toString().trim();


                if (name.isEmpty() || classText.isEmpty()) {
                    Toast.makeText(StudentAddActivity.this, "Введите имя и класс", Toast.LENGTH_SHORT).show();
                    return;
                }
                diskPersonStore.addStudent(name, lastName, Integer.parseInt(classText));

                Toast.makeText(StudentAddActivity.this, "Студент успешно добавлен", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}