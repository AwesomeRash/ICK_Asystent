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
    public static final String PRZEPISY_NAME = "przepisy";
    public static final String POSILKI_NAME = "posilki";


    public DBHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+LEKI_NAME+" "+
        "(id integer primary key, nazwa text, rodzaj integer, koniecPrzyjmowania text,kiedy text)"
        );
        db.execSQL("create table "+RACHUNKI_NAME+" "+
        "(id integer primary key, nazwa text, ostatnioOplacony text, jakCzesto integer, rachunek1 integer, rachunek2 integer, rachunek3 integer)"
        );
        db.execSQL("create table "+PRZEPISY_NAME+" "+
        "(id integer primary key, nazwa text, trudnosc text, czas text, skladniki text, przepis text, obraz integer)");
        db.execSQL("create table "+POSILKI_NAME+" "+
        "(id integer primary key, nazwa text, typ integer, godzina text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVerion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+LEKI_NAME);
       db.execSQL("DROP TABLE IF EXISTS "+RACHUNKI_NAME);
       db.execSQL("DROP TABLE IF EXISTS "+PRZEPISY_NAME);
       db.execSQL("DROP TABLE IF EXISTS "+POSILKI_NAME);
       onCreate(db);
    }

    public void resetDB(){
        SQLiteDatabase currentDB = getWritableDatabase();
        int version = currentDB.getVersion();
        onUpgrade(currentDB, version, version+1 );

    }


    // inne metody do obsługi DB idą tutaj


    // LEKARSTWA
    public LekDBModel getLek(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+LEKI_NAME+" where id="+id+"", null);

        if(res != null)
            res.moveToFirst();

        LekDBModel lekDBModel = new LekDBModel(res.getInt(res.getColumnIndex("id")),
                                                res.getString(res.getColumnIndex("nazwa")),
                                                res.getInt(res.getColumnIndex("rodzaj")),
                                                res.getString(res.getColumnIndex("koniecPrzyjmowania")),
                                                res.getString(res.getColumnIndex("kiedy"))
                                                );

        return lekDBModel;
    }

    public boolean updateLek(Integer id, String nazwa, Integer rodzaj, String koniecPrzyjmowania, String kiedy ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("kiedy",kiedy);
        contentValues.put("rodzaj",rodzaj);
        contentValues.put("koniecPrzyjmowania", koniecPrzyjmowania);
        db.update(LEKI_NAME, contentValues, "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public long createLek(String nazwa, Integer rodzaj, String koniecPrzyjmowania, String kiedy ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa",nazwa);
        contentValues.put("kiedy",kiedy);
        contentValues.put("koniecPrzyjmowania",koniecPrzyjmowania);
        contentValues.put("rodzaj",rodzaj);
        long db_id = db.insert(LEKI_NAME, null, contentValues);

        return db_id;
    }

    public Integer deleteLek(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(LEKI_NAME, "id = ?", new String[] {Integer.toString(id)});
    }

    public ArrayList<LekDBModel> getAllLek(){
        ArrayList<LekDBModel> arrayList = new ArrayList<>();
        String selectQuary = "SELECT * FROM "+LEKI_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(selectQuary,null);

        if(res.moveToFirst()){
            do{
                LekDBModel lekDBModel = new LekDBModel(res.getInt(res.getColumnIndex("id")),
                        res.getString(res.getColumnIndex("nazwa")),
                        res.getInt(res.getColumnIndex("rodzaj")),
                        res.getString(res.getColumnIndex("koniecPrzyjmowania")),
                        res.getString(res.getColumnIndex("kiedy"))
                );

                arrayList.add(lekDBModel);
            }
            while(res.moveToNext());
        }
        return arrayList;
    }



// RACHUNKI
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


    // PRZEPISY
    public PrzepisDBModel getPrzepis(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+PRZEPISY_NAME+" where id="+id+"", null);

        if(res != null)
            res.moveToFirst();

        PrzepisDBModel przepis = new PrzepisDBModel(
                res.getInt(res.getColumnIndex("id")),
                res.getString(res.getColumnIndex("nazwa")),
                res.getString(res.getColumnIndex("trudnosc")),
                res.getString(res.getColumnIndex("czas")),
                res.getString(res.getColumnIndex("skladniki")),
                res.getString(res.getColumnIndex("przepis")),
                res.getInt(res.getColumnIndex("obraz"))
        );

        return przepis;
    }

    public PrzepisDBModel getPrzepisName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from "+PRZEPISY_NAME+" where nazwa LIKE '"+name+"'",null);

        if(res != null)
            res.moveToFirst();

        PrzepisDBModel przepis = new PrzepisDBModel(
                res.getInt(res.getColumnIndex("id")),
                res.getString(res.getColumnIndex("nazwa")),
                res.getString(res.getColumnIndex("trudnosc")),
                res.getString(res.getColumnIndex("czas")),
                res.getString(res.getColumnIndex("skladniki")),
                res.getString(res.getColumnIndex("przepis")),
                res.getInt(res.getColumnIndex("obraz"))
        );

        return przepis;
    }

    public boolean updatePrzepis(int id, String nazwa, String trudnosc, String czas, String skladniki, String przepis, int obraz){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa", nazwa);
        contentValues.put("trudnosc",trudnosc);
        contentValues.put("czas",czas);
        contentValues.put("skladniki",skladniki);
        contentValues.put("przepis",przepis);
        contentValues.put("obraz",obraz);
        db.update(PRZEPISY_NAME, contentValues, "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public long createPrzepis(String nazwa, String trudnosc, String czas, String skladniki, String przepis, int obraz){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa", nazwa);
        contentValues.put("trudnosc",trudnosc);
        contentValues.put("czas",czas);
        contentValues.put("skladniki",skladniki);
        contentValues.put("przepis",przepis);
        contentValues.put("obraz",obraz);

        long db_id= db.insert(PRZEPISY_NAME, null,contentValues);

        return db_id;
    }

    public Integer deletePrzepis(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(PRZEPISY_NAME, "id = ?", new String[] {Integer.toString(id)});
    }


    public ArrayList<PrzepisDBModel> getAllPrzepis(){
        ArrayList<PrzepisDBModel> przepisy = new ArrayList<>();
        String selectQuary = "SELECT * FROM "+PRZEPISY_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(selectQuary,null);

        if(res.moveToFirst()){
            do{
                PrzepisDBModel prz = new PrzepisDBModel(
                        res.getInt(res.getColumnIndex("id")),
                        res.getString(res.getColumnIndex("nazwa")),
                        res.getString(res.getColumnIndex("trudnosc")),
                        res.getString(res.getColumnIndex("czas")),
                        res.getString(res.getColumnIndex("skladniki")),
                        res.getString(res.getColumnIndex("przepis")),
                        res.getInt(res.getColumnIndex("obraz"))
                );

                przepisy.add(prz);
            }
            while(res.moveToNext());
        }
        return przepisy;
    }

    // POSILKI


    public PosilekDBModel getPosilek(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+POSILKI_NAME+" where id="+id+"", null);

        if(res != null)
            res.moveToFirst();

        PosilekDBModel posilek = new PosilekDBModel(
                res.getInt(res.getColumnIndex("id")),
                res.getString(res.getColumnIndex("nazwa")),
                res.getInt(res.getColumnIndex("typ")),
                res.getString(res.getColumnIndex("godzina"))
        );

        return posilek;
    }

    public PosilekDBModel getPosilekName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from "+POSILKI_NAME+" where nazwa LIKE '"+name+"'",null);

        if(res != null)
            res.moveToFirst();

        PosilekDBModel posilek = new PosilekDBModel(
                res.getInt(res.getColumnIndex("id")),
                res.getString(res.getColumnIndex("nazwa")),
                res.getInt(res.getColumnIndex("typ")),
                res.getString(res.getColumnIndex("godzina"))
        );

        return posilek;
    }

    public boolean updatePosilek(int id, String nazwa, int typ, String godzina){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa", nazwa);
        contentValues.put("godzina",godzina);
        contentValues.put("typ",typ);

        db.update(POSILKI_NAME, contentValues, "id=?", new String[]{Integer.toString(id)});
        return true;
    }

    public long createPosilek(String nazwa, int typ, String godzina){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa", nazwa);
        contentValues.put("godzina",godzina);
        contentValues.put("typ",typ);

        long db_id= db.insert(POSILKI_NAME, null,contentValues);

        return db_id;
    }

    public Integer deletePosilek(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(POSILKI_NAME, "id = ?", new String[] {Integer.toString(id)});
    }


    public ArrayList<PosilekDBModel> getAllPosilek(){
        ArrayList<PosilekDBModel> posilki = new ArrayList<>();
        String selectQuary = "SELECT * FROM "+POSILKI_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(selectQuary,null);

        if(res.moveToFirst()){
            do{
                PosilekDBModel pos = new PosilekDBModel(
                        res.getInt(res.getColumnIndex("id")),
                        res.getString(res.getColumnIndex("nazwa")),
                        res.getInt(res.getColumnIndex("typ")),
                        res.getString(res.getColumnIndex("godzina"))
                );

                posilki.add(pos);
            }
            while(res.moveToNext());
        }
        return posilki;
    }




}
