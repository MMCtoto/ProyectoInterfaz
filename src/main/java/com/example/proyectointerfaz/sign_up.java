package com.example.proyectointerfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    EditText etUsuario;
    EditText etPassword;
    EditText etCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsuario = findViewById(R.id.etsignupUsu);
        etPassword = findViewById(R.id.etsignupCon);
        etCorreo = findViewById(R.id.etsignupCor);
    }
    public void cancelar(View v) {
        Intent i = new Intent(this, login.class);
        startActivity(i);
    }

    public void signup(View view) {
        String usuario = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String correo = etPassword.getText().toString().trim();

        if(usuario.isEmpty() || password.isEmpty() || correo.isEmpty()) {
            Toast.makeText(this, R.string.debe_introducir, Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, ButtonAPPBarActivity.class);
            startActivity(i);
        }

    }
}
