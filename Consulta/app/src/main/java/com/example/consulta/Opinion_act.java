package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;

public class Opinion_act extends AppCompatActivity {

    private RatingBar primero;
    private RatingBar segundo;
    private RatingBar tercero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);

        primero = findViewById(R.id.ratingPri);
        segundo = findViewById(R.id.ratingSeg);
        tercero = findViewById(R.id.ratingTer);

        primero.setRating(5);
        segundo.setRating(2);
        tercero.setRating(4);

    }
}