package com.example.practiceapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.listener.ItemClickListener;
import com.example.practiceapplication.adapter.StudentsAdapter;
import com.example.practiceapplication.models.Student;
import com.example.practiceapplication.utils.Utils;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements ItemClickListener {
    private Utils testPrefs;
    private StudentsAdapter studentsAdapter;
    private RecyclerView listStudents;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        listStudents = findViewById(R.id.list_students);
        students = Utils.getStudents();
//        buildAlertDialog();
//        buildSharedPreferences();
//        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager_container, new LoginFragment()).commit();
//        ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_list_item_1);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        studentsAdapter = new StudentsAdapter(this, students, listStudents);
        studentsAdapter.setItemClickListener(this);
//        listStudents.addItemDecoration(new VerticalItemOffsetDecoration(10));
//        listStudents.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        listStudents.setAdapter(studentsAdapter);
        final SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(listStudents);
    }

    private void buildSharedPreferences() {
        testPrefs = Utils.init(this, "TestPrefs");
        testPrefs.putString("test", "testing");
        testPrefs.finish();
        Toast.makeText(this, testPrefs.getString("test"), Toast.LENGTH_SHORT).show();
    }

    private void buildAlertDialog() {
        View view = getLayoutInflater().inflate(R.layout.layout_custom_title, null);
        String[] items = new String[]{"one", "two", "three", "four", "five", "one", "two", "three", "four", "five", "one", "two", "three", "four", "five"};
        boolean[] checkedItems = new boolean[items.length];
        AlertDialog alertDialog = new AlertDialog.Builder(this).
                setCustomTitle(view).
                setAdapter(new ArrayAdapter<>(this, android.R.layout.select_dialog_item, items), (dialogInterface, i) -> {
                    Toast.makeText(this, items[i], Toast.LENGTH_SHORT).show();
                }).
                setPositiveButton("Ok", (dialogInterface, i) -> {
                    Toast.makeText(this, "Ok clicked", Toast.LENGTH_SHORT).show();
                }).
                setNegativeButton("Cancel", (dialogInterface, i) -> {
                    Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                }).
                setCancelable(false).
                create();
        alertDialog.show();
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, students.get(position).getName(), Toast.LENGTH_LONG).show();
    }
}