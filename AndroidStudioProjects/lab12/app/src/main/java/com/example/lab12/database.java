package com.example.lab12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String database_name = "lab_12_signup.db";

    public database(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table signup (_id integer primary key autoincrement, first_name text, " +
                "last_name text, email text , password text )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists signup");
        onCreate(sqLiteDatabase);
    }

    //Creating method for inserting data into database
    public boolean data_insertion_database(String first_name,String last_name, String email, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", first_name);
        contentValues.put("last_name", last_name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long check = database.insert("signup", null, contentValues);
        if (check == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor get_info(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from signup ", null);
        return cursor;
    }

}

