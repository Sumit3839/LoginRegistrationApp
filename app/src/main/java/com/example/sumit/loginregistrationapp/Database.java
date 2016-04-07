package com.example.sumit.loginregistrationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sumit on 14-01-2016.
 */
public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 3;
    private static final String COLUMN_ID = "db";
    private static final String TABLE_NAME = "login";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PASSWORD = "pass";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_NO = "no";
    Login login;
    Context context;
    //private static final String DATABASE_NAME="db";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, "
                + COLUMN_NO + " NUMBER, "
                + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT, " +
                COLUMN_USERNAME + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void insertData(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, login.getName());
        values.put(COLUMN_PASSWORD, login.getPass());
        values.put(COLUMN_EMAIL, login.getEmail());
        values.put(COLUMN_USERNAME, login.getUsername());
        values.put(COLUMN_NO, login.getNo());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Boolean getData(String username, String password) {
        boolean z = false;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_USERNAME + "," + COLUMN_PASSWORD + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String str = cursor.getString(0);
                String str1 = cursor.getString(1);
                if (str.equals(username) && str1.equals(password)) {
                    z = true;
                    break;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return z;

    }

    public int getCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

    /*public Boolean getDataPassword(String password) {
        boolean b = false;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(0);
                if (a.equals(password)) {
                    b = true;
                    break;
                }

            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return b;
    }*/
    public List<Login> getAllData() {
        List<Login> loginList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Login login = new Login();
                login.setName(cursor.getString(1));
                login.setPass(cursor.getString(2));
                login.setUsername(cursor.getString(3));
                login.setNo(cursor.getString(4));
                login.setEmail(cursor.getString(5));
                loginList.add(login);
            } while (cursor.moveToNext());
        }

        //Toast.makeText(context, "" + loginList, Toast.LENGTH_SHORT).show();
        return loginList;
    }
}
