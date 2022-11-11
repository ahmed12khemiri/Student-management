package com.example.studentdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class StudentOpenHelper extends SQLiteOpenHelper {

        private Context context;
        private static final String DATABASE_NAME= "Student";
        private static final int DATABASE_VERSION= 1;
        private static final String TABLE_NAME = "student";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_NOM = "Name";
        private static final String COLUMN_NOTE = "Note";

    public StudentOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
            this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                        "( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NOM + " TEXT," +
                        COLUMN_NOTE + " DOUBLE);";

 db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
onCreate(db);

    }
    void addStudent(Student s){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues() ;
            cv.put(COLUMN_NOM, s.getNom());
            cv.put(COLUMN_NOTE, s.getNote());
        long result = db.insert(TABLE_NAME, null,cv);
            if ( result == -1 ) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "sucess", Toast.LENGTH_SHORT).show();
            }


    }

    public ArrayList<Student> getstudentData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Student> arrayList= new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME , null);
        while (cursor.moveToNext()){
            String id=cursor.getString(0);
            String Name=cursor.getString(1);
            String Note=cursor.getString(2);
            Student student=new Student (id ,Name,Note);
            arrayList.add( student );
        }

return arrayList;
    }
}

