package com.example.medicapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.medicapp.R;

public class AgregarMedicamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medicamento);

        getSupportActionBar().setTitle("Agregar Medicamento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
