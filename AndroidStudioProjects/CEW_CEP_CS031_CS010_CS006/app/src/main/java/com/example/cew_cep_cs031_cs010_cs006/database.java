package com.example.cew_cep_cs031_cs010_cs006;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String database_name = "signup.db";

    public database(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table user_signup (_id integer primary key autoincrement, username text , email text , password text )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists user_signup");
        onCreate(sqLiteDatabase);
    }

    //Creating method for inserting data into database
    public boolean data_insertion_database(String username, String email, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long check = database.insert("user_signup", null, contentValues);
        if (check == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor get_info(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_signup ", null);
        return cursor;
    }

}
