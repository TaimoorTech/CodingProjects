package com.example.dbms_cs031_cs010_cs006_cs008;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class databaseOpenHelper extends SQLiteAssetHelper {
    private static String name = "";
    private static final int version = 1;

    public databaseOpenHelper(Context context, String db) {
        super(context, db, null, version);
    }
}
