package com.example.controle2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

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
        ContentValues cote = new ContentValues();
        cote.put(COL2,E.getRaison_Sociale());
        cote.put(COL3,E.getAdresse());
        cote.put(COL4,E.getCapitale());

        return sqLiteDatabase.insert(TABLE_NAME,null,cote);
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
    public static long UpdateEntreprise(SQLiteDatabase sqLiteDatabase, Entreprise E){
        ContentValues ct = new ContentValues();
        ct.put(COL2,E.getRaison_Sociale());
        ct.put(COL3,E.getAdresse());
        ct.put(COL4,E.getCapitale());
        return sqLiteDatabase.update(TABLE_NAME,ct,"ID = " + E.getID(),null);
    }

    public static long DeleteEntreprise(SQLiteDatabase sqLiteDatabase, int id){
        return sqLiteDatabase.delete(TABLE_NAME,"ID = " + id,null);
    }
    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase sqLiteDatabase) {
        ArrayList<Entreprise> Entrps = new ArrayList<>();
        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cur.moveToNext()) {
            Entreprise E = new Entreprise();
            E.setID(cur.getInt(0));
            E.setRaison_Sociale(cur.getString(1));
            E.setAdresse(cur.getString(2));
            E.setCapitale(cur.getDouble(3));

            Entrps.add(E);
        }
        return Entrps;
    }

    public static Entreprise getOneEntreprise(SQLiteDatabase sqLiteDatabase, int id) {
        Entreprise E = null;
        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID=" + id, null);

        if (cur.moveToNext()) {
            E = new Entreprise();
            E.setID(cur.getInt(0));
            E.setRaison_Sociale(cur.getString(1));
            E.setAdresse(cur.getString(2));
            E.setCapitale(cur.getDouble(3));

        }
        return E;
}
}



