package com.example.studentdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> arrayList;

    public StudentAdapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView=inflater.inflate(R.layout.activity_student_list,null);
        EditText EditName=convertView.findViewById(R.id.EditName);
        EditText EditNote=convertView.findViewById(R.id.EditNote);

        return convertView;
    }
}
