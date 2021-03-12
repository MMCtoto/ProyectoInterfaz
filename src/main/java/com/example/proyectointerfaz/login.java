package com.example.proyectointerfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Miguel
 * @see login
 */

public class login extends AppCompatActivity {
    EditText etUsuario;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etusuario);
        etPassword = findViewById(R.id.etcontraseña);
    }
    public void registro(View v) {
        Intent i = new Intent(this, sign_up.class);
        startActivity(i);
    }
    public void login(View v) {
        String usuario = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(usuario.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, R.string.debe_introducir, Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
    public void guest(View v) {
        Intent i = new Intent(this, Invitado.class);
        startActivity(i);
    }

}