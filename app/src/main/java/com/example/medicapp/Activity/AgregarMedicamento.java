package com.example.medicapp.Activity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.medicapp.BDSQLite.ConexionSQLiteHelper;
import com.example.medicapp.BDSQLite.Constantes;
import com.example.medicapp.R;

import java.util.Calendar;

public class AgregarMedicamento extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnFechaInicio, btnFechaFinal, btnGuardar;
    EditText txtFechaInicial, txtFechaFinal, txtNombreAlt;
    SearchView searchViewMedicamento;
    Spinner spinnerFrecuenciaHrs;
    int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medicamento);

        getSupportActionBar().setTitle("Agregar Medicamento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnFechaInicio = findViewById(R.id.btnFechaInicio);
        btnFechaFinal = findViewById(R.id.btnFechaFinal);
        btnGuardar = findViewById(R.id.btnGuardar);
        txtFechaInicial = findViewById(R.id.txtFechaInicio);
        txtFechaFinal =  findViewById(R.id.txtFechaFinal);
        txtNombreAlt = findViewById(R.id.txtNombreAlt);
        searchViewMedicamento = findViewById(R.id.searchViewMedicamento);
        spinnerFrecuenciaHrs = findViewById(R.id.spinnerFrecuenciaHrs);


        btnFechaInicio.setOnClickListener(this);
        btnFechaFinal.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        spinnerFrecuenciaHrs.setOnItemSelectedListener(this);


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
                    txtFechaInicial.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
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

        if(v == btnGuardar){
            agregarMedicamentoSQL();
        }
    }

    private void agregarMedicamentoSQL() {

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios2",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO "+Constantes.TABLA_MEDICAMENTO+" ("+Constantes.NOMBRE_MEDICAMENTO+","+Constantes.NOMBRE_ALTER+","+Constantes.FECHA_INICIAL+","+Constantes.FECHA_FINAL+","+Constantes.FRECUENCIA+") " +
                "VALUES ('"+searchViewMedicamento.getQuery().toString()+"','"+txtNombreAlt.getText().toString()+"','"+txtFechaInicial.getText().toString()+"','"+txtFechaFinal.getText().toString()+"', '"+spinnerFrecuenciaHrs.getSelectedItem().toString()+"')";

        db.execSQL(insert);


        Toast.makeText(getApplicationContext(),"Medicamento agregado correctamente",Toast.LENGTH_SHORT).show();
        db.close();

        searchViewMedicamento.setQuery("", false);
        txtNombreAlt.getText().clear();
        txtFechaInicial.getText().clear();
        txtFechaFinal.getText().clear();
        spinnerFrecuenciaHrs.setAdapter(null);



    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}