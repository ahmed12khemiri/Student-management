package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText EditName;
    EditText EditNote;
    Button BtnAdd;
    ImageButton StudentList;
    StudentOpenHelper studentDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentList = findViewById(R.id.StudentList);
        StudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( view.getContext() ,StudentList.class );
                startActivity(intent);
            }
        });

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentOpenHelper myDB = new StudentOpenHelper(MainActivity.this);
                Student s=new Student(null,EditName.getText().toString(),
                        EditNote.getText().toString());
                myDB.addStudent( s );
            }
        });


        EditName = findViewById(R.id.EditName);
        EditNote = findViewById(R.id.EditNote);

    }
}