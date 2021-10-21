package com.iesseveroochoa.p3startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMetodoAnterior,btnMetodoNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMetodoAnterior=findViewById(R.id.btnMetodoAnterior);
        btnMetodoNuevo=findViewById(R.id.btnMetodoNuevo);

        btnMetodoAnterior.setOnClickListener(v-> abrirMetodoAnterior());
        btnMetodoNuevo.setOnClickListener(v-> abrirMetodoNuevo());
    }



    private void abrirMetodoAnterior() {
        Intent intent =new Intent(this, MetodoAnteriorActivity.class);
        startActivity(intent);
    }

    private void abrirMetodoNuevo() {
        Intent intent =new Intent(this, MetodoAnteriorActivity.class);
        startActivity(intent);
    }
}