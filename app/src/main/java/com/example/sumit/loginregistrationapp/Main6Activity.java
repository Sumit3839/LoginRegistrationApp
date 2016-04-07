package com.example.sumit.loginregistrationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Login> list;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        database = new Database(Main6Activity.this);
        database.getAllData();
        list = new ArrayList<>();
        list = database.getAllData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBAdapter adapter = new DBAdapter(Main6Activity.this, list);
        recyclerView.setAdapter(adapter);
    }

}
