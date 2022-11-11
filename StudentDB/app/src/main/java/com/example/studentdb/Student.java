package com.example.studentdb;

import java.util.jar.Attributes;

public class Student {
    String ID;
    String Nom;
    String Note;

    ///////////////////

    public Student(String ID, String nom, String note) {
        this.ID = ID;
        Nom = nom;
        Note = note;
    }

    ///////////////////

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

   ///////////////////

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    ///////////////////

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
