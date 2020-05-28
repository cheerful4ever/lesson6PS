package com.example.lesson6ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAddTask;
    ListView lv;
    ArrayList<Task> al;
    TaskAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = findViewById(R.id.btnAddTask);
        lv = findViewById(R.id.listview);
        al = new ArrayList<>();
        DBhelper dbH = new DBhelper(MainActivity.this);
        al.addAll(dbH.getTasks());
        dbH.close();
        ca = new TaskAdapter(this, R.layout.row, al);
        lv.setAdapter(ca);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9) {
            DBhelper dbH = new DBhelper(MainActivity.this);
            al.clear();
            al.addAll(dbH.getTasks());
            dbH.close();
            ca.notifyDataSetChanged();
        }
    }
}
