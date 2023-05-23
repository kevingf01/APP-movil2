package com.example.consulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        VideoView mivideo = findViewById(R.id.videoClinica);

    String videoP = "android.resource://" + getPackageName() + "/" + R.raw.video_clinica;
    Uri uri=Uri.parse(videoP);
    mivideo.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);

    }

    public void Medicos (View med){
        Intent i = new Intent(this, Medico_act.class);
        startActivity(i);
    }

    public void Agendar (View age){
        Intent i = new Intent(this, Agendar_act.class);
        startActivity(i);
    }

    public void Opinion (View opi){
        Intent i = new Intent(this, Opinion_act.class);
        startActivity(i);
    }

    public void Info (View inf){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }


}

