package com.example.medicapp.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.medicapp.R;

import java.util.Calendar;

public class AgregarMedicamento extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnFechaInicio, btnFechaFinal;
    EditText txtFechaInicio, txtFechaFinal;
    int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medicamento);

        getSupportActionBar().setTitle("Agregar Medicamento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnFechaInicio = (Button) findViewById(R.id.btnFechaInicio);
        btnFechaFinal = (Button) findViewById(R.id.btnFechaFinal);
        txtFechaInicio = (EditText) findViewById(R.id.txtFechaInicio);
        txtFechaFinal = (EditText) findViewById(R.id.txtFechaFinal);
        Spinner spinnerFrec = findViewById(R.id.spinnerFrecuencia);


        btnFechaInicio.setOnClickListener(this);
        btnFechaFinal.setOnClickListener(this);
        spinnerFrec.setOnItemSelectedListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == btnFechaInicio) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtFechaInicio.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }
                    , dia, mes, año);
            datePickerDialog.show();
        }


        if (v == btnFechaFinal) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtFechaFinal.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }
                    , dia, mes, año);
            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}