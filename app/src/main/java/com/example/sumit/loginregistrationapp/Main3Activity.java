package com.example.sumit.loginregistrationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Toolbar toolbar;
    EditText e1, e2, e3, e4, e5, e6;
    Login login;
    Button btn;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        e1 = (EditText) findViewById(R.id.e);
        e2 = (EditText) findViewById(R.id.e1);
        e3 = (EditText) findViewById(R.id.e2);
        e4 = (EditText) findViewById(R.id.e3);
        e5 = (EditText) findViewById(R.id.e4);
        e6 = (EditText) findViewById(R.id.e5);
        btn = (Button) findViewById(R.id.view2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = new Login();
                db = new Database(Main3Activity.this);
                String name = e1.getText().toString();
                String username = e2.getText().toString();
                String email = e3.getText().toString();
                String phone = e4.getText().toString();
                String pass = e5.getText().toString();
                SharedPreferences preferences = getSharedPreferences("sumit", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", name);
                editor.putString("username", username);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.putString("pass", pass);
                editor.commit();
                login.setName(name);
                login.setEmail(email);
                login.setUsername(username);
                login.setNo(phone);
                login.setPass(pass);
                db.insertData(login);
                int a = db.getCount();
                Toast.makeText(getApplicationContext(), "" + a, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Data stored in Database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                //intent.putExtra("username", username);
                //intent.putExtra("password", pass);
                startActivity(intent);
            }
        });
    }
}
