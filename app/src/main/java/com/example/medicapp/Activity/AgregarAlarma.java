package com.example.medicapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.medicapp.R;

public class AgregarAlarma extends AppCompatActivity {

    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alarma);

        getSupportActionBar().setTitle("Agregar alarma");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






    }
}
