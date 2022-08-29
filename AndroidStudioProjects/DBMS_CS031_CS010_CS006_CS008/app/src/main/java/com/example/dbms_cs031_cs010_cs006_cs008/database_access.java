package com.example.dbms_cs031_cs010_cs006_cs008;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database_access {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String db_name;
    private static  database_access instance;
    int version;
    Cursor cursor = null;

    private database_access(Context context, String db){
//        if (db_name.equals("tv_informations.db")){
//            version = 1;
//        }
//        else if (db_name.equals("keyboard_informations.db")){
//            version = 1;
//        }
//        else if (db_name.equals("mouse_informations.db")){
//            version = 1;
//        }
        this.openHelper = new databaseOpenHelper(context, db);
        db_name = db;
    }

    public static database_access getInstance(Context context, String database){
        instance =  new database_access(context, database);
        return instance;
    }

    public void open_db(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close_db(){
        if (database!=null){
            this.database.close();
        }
    }

    public Cursor getInfo(){
        ArrayList<String> names = new ArrayList<>();
//        this.database = openHelper.getWritableDatabase();
        if(db_name.equals("tv_informations.db")){
            cursor = database.rawQuery("select * from InformationsAboutTv", null);
        }
        else if (db_name.equals("keyboard_informations.db")){
            cursor = database.rawQuery("select * from InformationsAboutKeyboard", null);
        }
        else if (db_name.equals("mouse_informations.db")){
            cursor = database.rawQuery("select * from InformationsAboutMouse", null);
        }

//        while(cursor.moveToNext()){
//            names.add(cursor.getString(0));
//        }
        return cursor;
    }


}
