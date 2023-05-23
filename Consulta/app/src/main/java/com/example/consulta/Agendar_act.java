package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.AdminSQLiteOpenHelper;

public class Agendar_act extends AppCompatActivity {

    private EditText etrut, etnom, etfech, ethor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        //llamar lo editText por id
        etrut = findViewById(R.id.idRut);
        etnom = findViewById(R.id.idNom);
        etfech = findViewById(R.id.idFech);
        ethor = findViewById(R.id.idHor);

    }

    public void añadirClientes (View aña){

        //Traer la BBDD
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Cliente", null, 1 );
        SQLiteDatabase db = admin.getWritableDatabase(); //permiso de escritura.

        if (!etrut.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues(); //agrupacion de valores
            registro.put("rut", etrut.getText().toString());
            registro.put("nombre", etnom.getText().toString());
            registro.put("fecha", etfech.getText().toString());
            registro.put("hora", ethor.getText().toString());

            db.insert("agendar", null, registro); //añadimos...
            db.close(); //Cerramos la BBDD.
            limpiarCampos();

            Toast.makeText(getBaseContext(), "Se ha agendado la hora", Toast.LENGTH_LONG).show();
        }
    }

    // Método para mostrar o consultar clientes.
    public void Consultar(View con)
    {
        // Constructor de mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cliente", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Permiso de sobreescritura.

        String codigo = etrut.getText().toString(); //Obtengo el id.

        if(!codigo.isEmpty()) //Si el code no esta vacio.
        {
            //Consulta de datos
            Cursor fila = db.rawQuery("SELECT nombre, fecha, hora FROM agendar WHERE rut =" + codigo, null);

            //Rellenamos los campos con la consulta
            if(fila.moveToFirst())
            {
                etnom.setText(fila.getString(0));
                etfech.setText(fila.getString(1));
                ethor.setText(fila.getString(2));
                db.close();
            }
            else
            {
                Toast.makeText(this, "La cita no existe", Toast.LENGTH_LONG).show();
                db.close();
            }


        }
        else
        {
            Toast.makeText(this, "Debe ingresare el Rut", Toast.LENGTH_LONG).show();
        }

    }

    // Método para eliminar campos de la database
    public void  eliminarClientes(View elim)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cliente", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = etrut.getText().toString();

        if(!codigo.isEmpty())
        {
            // eliminar por codigo
            int cantidad = db.delete("agendar", "rut="+codigo, null);
            db.close();
            limpiarCampos();
            if(cantidad == 1)
            {
                Toast.makeText(this, "Se ha eliminado la cita del n° "+codigo+" del calendario", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "El rut no existe", Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this, "Debe ingresare un rut", Toast.LENGTH_LONG).show();
        }
    }

    //Método actualizar
    public void actualizarClientes(View actu)
    {
        //Obtenemos la database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cliente", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //Campos de entrada
        String rut_cliente = etrut.getText().toString();
        String nom_cliente = etnom.getText().toString();
        String fech_cliente = etfech.getText().toString();
        String hor_cliente = ethor.getText().toString();

        if(!rut_cliente.isEmpty() && !nom_cliente.isEmpty() && !fech_cliente.isEmpty() && !hor_cliente.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("rut", rut_cliente);
            cont.put("nombre", nom_cliente);
            cont.put("fecha", fech_cliente);
            cont.put("hora", hor_cliente);

            int cantidad = db.update("agendar", cont, "rut="+rut_cliente, null);
            db.close();
            limpiarCampos();

            if(cantidad == 1)
            {
                Toast.makeText(this, "Se ha actualizado con éxito la hora", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_LONG).show();
            }

        }

    }


    public void limpiarCampos()
    {
        etrut.setText("");
        etnom.setText("");
        etfech.setText("");
        ethor.setText("");
    }



}