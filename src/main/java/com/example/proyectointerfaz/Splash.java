package com.example.proyectointerfaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.graphics.Typeface;

import com.bumptech.glide.Glide;


public class Splash extends AppCompatActivity {
    ImageView logo;
    ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        logo = findViewById(R.id.ivLogo);
        foto = findViewById(R.id.ivEldiego);

        Glide.with(this)
                .load(R.drawable.estadio)
                .fitCenter()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(logo);

        Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(fadein);
        foto.startAnimation(fadein);

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








