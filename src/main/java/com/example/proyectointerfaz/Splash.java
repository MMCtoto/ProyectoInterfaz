package com.example.proyectointerfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.graphics.Typeface;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView myImage = (ImageView)findViewById(R.id.imageView4);
        View mySubtitle = null;

        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, login.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}








