package com.example.medicapp.Activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.medicapp.Class.Doctor;
import com.example.medicapp.Class.Medicamento;
import com.example.medicapp.R;

import java.util.Calendar;

public class AgregarMedico extends AppCompatActivity implements View.OnClickListener {

    Button btnFecha, btnHora, btnGuardar;
    EditText txtFecha, txtHora, txtMedico,txtDomicilio,txtTel;
    int dia,mes,año,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medico);


        getSupportActionBar().setTitle("Agregar médico");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnFecha = (Button) findViewById(R.id.btnFecha);
        btnHora = (Button) findViewById(R.id.btnHora);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtHora = (EditText) findViewById(R.id.txtHora);
        txtMedico= (EditText)findViewById(R.id.txtMedico);
        txtDomicilio= (EditText)findViewById(R.id.txtDomicilio);
        txtTel= (EditText)findViewById(R.id.txtTel);
        btnGuardar=(Button) findViewById(R.id.btnGuardar);

        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==btnFecha){
            final Calendar c= Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,dia,mes,año);
            datePickerDialog.show();
        }

        if(v==btnHora){
            final Calendar c= Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timerPickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtHora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timerPickerDialog.show();
        }

        if (v == btnGuardar) {
            Doctor med;
            boolean hasname = (txtMedico.getText()!=null), hasdate1 = (txtFecha.getText() != null),
                    hasdate2 = (txtHora.getText() != null);
            if(!hasname){

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("No se puede guardar un medico sin nombre");
                dlgAlert.setTitle("Alerta");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                            }
                        });
            }
            if(!hasdate1 || !hasdate2){
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("La fecha y hora no es correcta");
                dlgAlert.setTitle("Alerta");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                            }
                        });
            }

            if (hasdate1 && hasdate2 && hasname){
                med=new Doctor(txtMedico.getText().toString().trim());
            }

        }
    }
}
