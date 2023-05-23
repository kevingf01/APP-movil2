package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import models.Medicos;

public class Medico_act extends AppCompatActivity {

    private Spinner spnMed; //Esta variable guarda el elemento
    Medicos med = new Medicos(); // traigo mi modelo
    private RatingBar barra;

    private TextView valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);

        spnMed = findViewById(R.id.spnMedico); //Obtengo el elemento grafico por ID
        barra = findViewById(R.id.rating);
        valor = findViewById(R.id.result);

        // Se crea un adpt para rellenar el spn

        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, med.getMedicos());
        spnMed.setAdapter(adapt); // Rellenar spinner
    }

    public void CalcularConsulta(View cc)
    {
        String opcion = spnMed.getSelectedItem().toString(); //Obtenemos lo seleccionado

        String nombre1 = med.getMedicos().get(0);
        String nombre2 = med.getMedicos().get(1);
        String nombre3 = med.getMedicos().get(2);

        switch (opcion){
            case "Nicolas Fernandez":
                valor.setText("El valor de medico "+ nombre1 + " es de 10.990");
                barra.setRating(2);
                break;
            case "Sofia Riquelme":
                valor.setText("El valor de la medica "+ nombre2 + " es de 15.990");
                barra.setRating(3);
                break;
            case "Sonic the Hedgehog":
                valor.setText("El valor del erizo "+ nombre3 + " es de 20.990");
                barra.setRating(5);
                break;
            default:
                break;
        }

    }



}