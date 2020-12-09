package com.example.proyectointerfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author FLaco
 *login
 */

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void registro(View v) {
        Intent i = new Intent(this, sign_up.class);
        startActivity(i);
    }
    public void login(View v) {

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

    }
    public void guest(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}