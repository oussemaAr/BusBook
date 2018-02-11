package dev.foursquad.busbook.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dev.foursquad.busbook.model.Horraire;
import dev.foursquad.busbook.model.Ville;

public class MyDB extends SQLiteOpenHelper {

    public MyDB(Context context) {
        super(context, "busBook", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ville(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nom TEXT)");
        db.execSQL("CREATE TABLE horraire(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, destination INTEGER, aller_depart TEXT, aller_arrive TEXT, retour_depart TEXT,retour_arrive TEXT)");
    }

    public List<Ville> getVille() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ville", null);
        ArrayList<Ville> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Ville ville = new Ville();
                ville.id = cursor.getInt(cursor.getColumnIndex("_id"));
                ville.nom = cursor.getString(cursor.getColumnIndex("nom"));
                list.add(ville);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ArrayList<Horraire> horraireList(int ville) {
        ArrayList<Horraire> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM horraire, ville WHERE destination = ?", new String[]{String.valueOf(ville)});
        if (cursor.moveToFirst()) {
            do {
                Horraire horraire = new Horraire();
                horraire.allerDepart = cursor.getString(cursor.getColumnIndex("aller_depart"));
                horraire.allerArriver = cursor.getString(cursor.getColumnIndex("aller_arrive"));
                horraire.retourDepart = cursor.getString(cursor.getColumnIndex("retour_depart"));
                horraire.retourArrive = cursor.getString(cursor.getColumnIndex("retour_arrive"));
                list.add(horraire);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void insertVille(String ville) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", ville);
        db.insert("ville", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertHorraire(Horraire horraire) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("aller_depart", horraire.allerDepart);
        values.put("aller_arrive", horraire.allerArriver);
        values.put("retour_depart", horraire.retourDepart);
        values.put("retour_arrive", horraire.retourArrive);
        values.put("destination", horraire.destination);
        db.insert("horraire", null, values);
    }
}
