package com.example.materialapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //BaseDeDatos es el nombre de nuestra base de datos
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        //la tabla se llama materiales, entre parentesis esta lo que va en sus columnas, primero el nombre y despues el tipo de dato
        BaseDeDatos.execSQL("create table materiales(id_mat int primary key, nombre_mat text, costo_mat real)");

    }
    public boolean materialExiste(String id_mat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = { "id_mat" };
        String selection = "id_mat = ?";
        String[] selectionArgs = { id_mat };
        Cursor cursor = db.query("materiales", projection, selection, selectionArgs, null, null, null);
        boolean existe = (cursor.getCount() > 0);
        cursor.close();
        return existe;
    }




    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int oldVersion, int newVersion) {

    }
}
