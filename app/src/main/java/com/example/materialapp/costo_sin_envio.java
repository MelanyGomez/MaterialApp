package com.example.materialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;


public class costo_sin_envio extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public Spinner spinnerMateriales;
    public ArrayList<String> listaMateriales;
    public ArrayAdapter<String> materialesAdapter;

    private ArrayList<String> obtenerNombresMateriales() {
        ArrayList<String> listaMateriales = new ArrayList<>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT nombre_mat FROM materiales", null);
        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(1);
                listaMateriales.add(nombre);
            } while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();
        return listaMateriales;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo_sin_envio);

        spinnerMateriales = findViewById(R.id.spinnerMateriales);

        listaMateriales = obtenerNombresMateriales();

        materialesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaMateriales);
        materialesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMateriales.setAdapter(materialesAdapter);


    }

        


    public void ir_editar_costo_materiales(View view){
        Intent intent = new Intent(costo_sin_envio.this,editar_costo_materiales.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}