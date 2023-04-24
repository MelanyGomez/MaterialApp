package com.example.materialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;



public class editar_costo_materiales extends AppCompatActivity {
    //Declaramos los objetos que vamos a usar
   public EditText et_id_mat, et_nombre_mat, et_costo_mat;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_editar_costo_materiales);
       //Recuperamos los datos que estan dentro de nuestros edit text con el id que le asignamos en nuestro XML
       et_id_mat = (EditText)findViewById(R.id.et_id_mat);
       et_nombre_mat = (EditText)findViewById(R.id.et_nombre_mat);
       et_costo_mat = (EditText)findViewById(R.id.et_costo_mat);


   }

   public void Registrar_mat (View view){
       //creamos un objeto llamado admin que va a manipulaar nuestra base de datos
       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracon", null,1);
        //abrimos nuestra bae de datos
       SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        //recuperamos daos de nuestro edit text
       String id_mat = et_id_mat.getText().toString();
       String nombre_mat = et_nombre_mat.getText().toString();
       String costo_mat = et_costo_mat.getText().toString();
        //ese if ve si estan llenos todos los campos
       if(!id_mat.isEmpty() && !nombre_mat.isEmpty() && !costo_mat.isEmpty()){

           //vamos a ver si ya existe un material registrdo con ese id
           if(admin.materialExiste(id_mat)){
               Toast.makeText(this, "El material con ID " + id_mat + " ya existe", Toast.LENGTH_SHORT).show();

           } else {
               //creamos un objeto de la clase ContentValues y se llama registro_mat
               //va a almacenar nuestros datos
               ContentValues registro_mat = new ContentValues();
               //metemos nuestros datos en ese registro_mat
               registro_mat.put("id_mat", id_mat);
               registro_mat.put("nombre_mat", nombre_mat);
               registro_mat.put("costo_mat", costo_mat);
               //insertamos en la tabla materiales nuestro contenedor llamado registro_mat
               BaseDeDatos.insert("materiales", null, registro_mat);


               //deja limpios los edit text despues de registrar
               et_id_mat.setText("");
               et_nombre_mat.setText("");
               et_costo_mat.setText("");
               BaseDeDatos.close();
               Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
               Toast.makeText(this, id_mat+nombre_mat+costo_mat,Toast.LENGTH_SHORT).show();
           }

       }else{

           Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
    }


   }

}
