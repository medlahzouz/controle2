package com.example.controle2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static String DB_NAME = " enterprises.db";
    public static String TABLE_NAME = "Entreprise";
    public static String COL1 = "ID";
    public static String COL2 = "Raison_Sociale";
    public static String COL3 = "Adresse";
    public static String COL4 = "Capitale";


    public MyDatabase(Context c) {
        super(c,DB_NAME,null,1);
    }
    public static long AddEntreprise(SQLiteDatabase sqLiteDatabase, Entreprise E){
        ContentValues ct = new ContentValues();
        ct.put(COL2,E.getRaison_Sociale());
        ct.put(COL3,E.getAdresse());
        ct.put(COL4,E.getCapitale());

        return sqLiteDatabase.insert(TABLE_NAME,null,ct);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " integer primary key autoincrement," + COL2 + " text," + COL3 + " text," + COL4 + " double )";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE "+TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

        }

