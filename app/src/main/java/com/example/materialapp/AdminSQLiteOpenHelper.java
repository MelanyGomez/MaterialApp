package com.example.materialapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //el nombre que le asignamos a nuestra base de datos es BaseDeDatos
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table materiales(id_mat integer primary key autoincrement, nombre_mat text(32) not null, precio_mat real(7,3)not null)");
        BaseDeDatos.execSQL("create table maquinaria(id_maq int primary key, nombre_maq text(32) not null, descripcion_mat text(120) not null, precio_maq_mes real(7,3)not null)");
        BaseDeDatos.execSQL("create table cliente(id_cli int primary key, nombre_cli text (32) not null, telefono_cli text(15)not null, direccion text(256) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
