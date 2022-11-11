package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class StudentList extends AppCompatActivity {
    StudentOpenHelper studentDb;
    ListView listView;
    ArrayList<Student> arrayList;
    StudentAdapter adapter;
    StudentOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        db = new StudentOpenHelper(StudentList.this);
                listView = findViewById(R.id.listView);
                showStudentData();

    }

    private void showStudentData() {

        arrayList=studentDb.getstudentData();
        adapter=new StudentAdapter(this, arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}