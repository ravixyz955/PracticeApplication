package com.example.practiceapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.practiceapplication.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Utils(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static Utils init(Context context, String name) {
        return new Utils(context, name);
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void finish() {
        if (sharedPreferences != null && editor != null) {
            editor.commit();
        }
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("name" + i);
            student.setVillage("village" + i);
            students.add(student);
        }
        return students;
    }
}
