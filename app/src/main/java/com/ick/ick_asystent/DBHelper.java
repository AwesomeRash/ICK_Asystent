package com.ick.ick_asystent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Roderick on 05.01.2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ick_asystent.db";
    public static final String LEKI_NAME = "leki";
    public static final String RACHUNKI_NAME = "rach";


    public DBHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+LEKI_NAME+" "+
        "(id integer primary key, nazwa text, rodzaj integer, kiedy text)"
        );
        db.execSQL("create table "+RACHUNKI_NAME+" "+
        "(id integer primary key, nazwa text, ostatnioOplacony text, jakCzesto integer, rachunek1 integer, rachunek2 integer, rachunek3 integer)"
        );
    }

    public void onUpgrade(SQLiteDatabase db, int oldVerion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+LEKI_NAME);
       db.execSQL("DROP TABLE IF EXISTS "+RACHUNKI_NAME);
       onCreate(db);
    }


    // inne metody do obsługi DB idą tutaj

    public LekDBModel getLek(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+LEKI_NAME+" where id="+id+"", null);

        if(res != null)
            res.moveToFirst();

        LekDBModel lekDBModel = new LekDBModel(res.getInt(res.getColumnIndex("id")),
                                                res.getString(res.getColumnIndex("nazwa")),
                                                res.getInt(res.getColumnIndex("rodzaj")),
                                                res.getString(res.getColumnIndex("kiedy"))
                                                );

        return lekDBModel;
    }

    public boolean updateLek(Integer id, String nazwa, Integer rodzaj, String kiedy ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("kiedy",kiedy);
        contentValues.put("rodzaj",rodzaj);
        db.update(LEKI_NAME, contentValues, "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public long createLek(String nazwa, Integer rodzaj, String kiedy ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("kiedy",kiedy);
        contentValues.put("rodzaj",rodzaj);
        long db_id = db.insert(LEKI_NAME, null, contentValues);

        return db_id;
    }

    public Integer deleteLek(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(LEKI_NAME, "id = ?", new String[] {Integer.toString(id)});
    }

 /*   public ArrayList<String> getAllLek(){
        ArrayList<String> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+LEKI_NAME, null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            arrayList.add(res.getString(res.getColumnIndex()));
            res.moveToNext();
        }

        return arrayList;
    }*/

    public RachunekDBModel getRachunek(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+RACHUNKI_NAME+" where id="+id+"", null);

        if(res != null)
            res.moveToFirst();

        RachunekDBModel rachunek = new RachunekDBModel(
                                                        res.getInt(res.getColumnIndex("id")),
                                                        res.getString(res.getColumnIndex("nazwa")),
                                                        res.getString(res.getColumnIndex("ostatnioOplacony")),
                                                        res.getInt(res.getColumnIndex("jakCzesto")),
                                                        res.getInt(res.getColumnIndex("rachunek1")),
                                                        res.getInt(res.getColumnIndex("rachunek2")),
                                                        res.getInt(res.getColumnIndex("rachunek3"))
                                                        );

        return rachunek;
    }

    public boolean updateRachunek(Integer id, String nazwa,String ostatnioOplacony, Integer jakCzesto, Integer rachunek1, Integer rachunek2, Integer rachunek3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("ostatnioOplacony",ostatnioOplacony);
        contentValues.put("jakCzesto",jakCzesto);
        contentValues.put("rachunek1",rachunek1);
        contentValues.put("rachunek2",rachunek2);
        contentValues.put("rachunek3",rachunek3);
        db.update(RACHUNKI_NAME, contentValues, "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public long createRachunek(String nazwa,String ostatnioOplacony, Integer jakCzesto, Integer rachunek1, Integer rachunek2, Integer rachunek3){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("ostatnioOplacony",ostatnioOplacony);
        contentValues.put("jakCzesto",jakCzesto);
        contentValues.put("rachunek1",rachunek1);
        contentValues.put("rachunek2",rachunek2);
        contentValues.put("rachunek3",rachunek3);
        long db_id= db.insert(RACHUNKI_NAME, null,contentValues);

        return db_id;
    }

    public Integer deleteRachunek(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(RACHUNKI_NAME, "id = ?", new String[] {Integer.toString(id)});
    }


    public ArrayList<RachunekDBModel> getAllRachunek(){
        ArrayList<RachunekDBModel> rachunki = new ArrayList<>();
        String selectQuary = "SELECT * FROM "+RACHUNKI_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(selectQuary,null);

        if(res.moveToFirst()){
            do{
                RachunekDBModel rach = new RachunekDBModel(
                        res.getInt(res.getColumnIndex("id")),
                        res.getString(res.getColumnIndex("nazwa")),
                        res.getString(res.getColumnIndex("ostatnioOplacony")),
                        res.getInt(res.getColumnIndex("jakCzesto")),
                        res.getInt(res.getColumnIndex("rachunek1")),
                        res.getInt(res.getColumnIndex("rachunek2")),
                        res.getInt(res.getColumnIndex("rachunek3"))
                );

                rachunki.add(rach);
            }
            while(res.moveToNext());
        }
       return rachunki;
    }


}
