package com.example.dbms_cs031_cs010_cs006_cs008;

import static java.sql.Types.ROWID;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class email_ordered_database extends SQLiteOpenHelper {

    private static final String database_name = "email_orders.db";
    public static final String EMAIL_ORDER = "order_";

    public email_ordered_database(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+EMAIL_ORDER+" (id integer PRIMARY KEY autoincrement,model_name text , rate text , quantity text , total_price text)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists "+ EMAIL_ORDER);
        onCreate(sqLiteDatabase);
    }

    //Creating method for inserting data into database
    public boolean data_insertion_database(ArrayList<String> model_name, ArrayList<Float> rating,
                                           ArrayList<String> quantity, ArrayList<String> total_price){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=0; i<model_name.size(); i++){
            contentValues.put("model_name", model_name.get(i));
            contentValues.put("rate", rating.get(i).toString());
            contentValues.put("quantity", quantity.get(i));
            contentValues.put("total_price", total_price.get(i));
            long check = database.insert(EMAIL_ORDER, null, contentValues);
        }
        return true;
    }

//    public Cursor get_info(){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery(new StringBuilder().append("select * from").append(email_order).toString(), null);
//        return cursor;
//    }


//    public void close_db(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        if (db!=null){
//            db.close();
//        }
//    }
}

