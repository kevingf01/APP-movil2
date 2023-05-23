package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText etuser;
    private EditText etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = findViewById(R.id.iduser);
        etpass = findViewById(R.id.etpass);

    }

    public void Login(View view) {

        String usu = etuser.getText().toString();
        String pass = etpass.getText().toString();

        // Comprobar campos vacios
        if (usu.equals("") || pass.equals(""))
        {
            // es una notificación en android.
            Toast.makeText(getBaseContext(), "Campos Vacíos", Toast.LENGTH_LONG).show();
        }else{
            // Válidamos campos erroneos
            //  if (!usu.equals("") && !pass.equals(""))
            // {
            //     Toast.makeText(getBaseContext(), "Campos Erroneos", Toast.LENGTH_LONG).show();
            // }else{

            //   Toast.makeText(getBaseContext(), "1", Toast.LENGTH_LONG).show();
            // Válidamos campos correctos
            if ( (usu.equals("yordan") && pass.equals("123")) || (usu.equals("kevin") && pass.equals("123")) )
            {

                Intent i = new Intent(this, Home_act.class); // me permite cambiar de activity
                startActivity(i);
            } else {

                Toast.makeText(getBaseContext(), "usuario no valido", Toast.LENGTH_LONG).show();
            }
        }

    }
}