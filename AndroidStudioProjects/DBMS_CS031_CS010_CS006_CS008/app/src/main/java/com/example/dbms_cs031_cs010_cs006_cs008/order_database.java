package com.example.dbms_cs031_cs010_cs006_cs008;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class order_database extends SQLiteOpenHelper {

    private static final String database_name = "active_order.db";

    public order_database(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table user_order (_id integer primary key autoincrement, model_name text , detailedInfo text , rating text, price text, quantity text, total_price text, model_image BLOB)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists user_order");
        onCreate(sqLiteDatabase);
    }

    //Creating method for inserting data into database
    public boolean data_insertion_database(String model_name, String detailedInfo, String rating,
                                           String price, String quantity, String total_price, byte[] image){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("model_name", model_name);
        contentValues.put("detailedInfo", detailedInfo);
        contentValues.put("rating", rating);
        contentValues.put("price", price);
        contentValues.put("quantity", quantity);
        contentValues.put("total_price", total_price);
        contentValues.put("model_image", image);
        long check = database.insert("user_order", null, contentValues);
        if (check == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor get_info(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_order", null);
        return cursor;
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ "user_order");
        db.close();
    }

    public void delete_data(String model_name){
        SQLiteDatabase db = this.getWritableDatabase();
        int r = db.delete("user_order", "model_name = '"+model_name+"'", null);
    }

//    public void close_db(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        if (db!=null){
//            db.close();
//        }
//    }
}
