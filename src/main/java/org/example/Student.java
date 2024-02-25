package org.example;

public class Student {
    String nama;
    int semester;
    boolean isActive;

    public Student(String nama, int semester, boolean isActive) {
        this.nama = nama;
        this.semester = semester;
        this.isActive = isActive;
    }

    public boolean isDoingMBKM() {
        if(this.semester > 6 && isActive == true) {
            return true;
        } else {
            return false;
        }
    }
}
