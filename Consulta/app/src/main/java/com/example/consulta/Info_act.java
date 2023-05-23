package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Info_act extends AppCompatActivity {

    // variables para el slider
    private ViewFlipper vf;
    private int [] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        vf = findViewById(R.id.slider); //Se busca el slider por id

        // Invocar la función en un iterar

        for(int i=0; i < images.length; i++)
        {
            flipImage(images[i]);
        }
    }

    public void flipImage(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        // Configuramos nuestro slider.
        vf.addView(view);
        vf.setFlipInterval(3000);  // intervalo
        vf.setAutoStart(true);    // Que comience automaticamente

        // Manejamos el sentido de la dirección
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}