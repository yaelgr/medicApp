package com.example.medicapp.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.medicapp.BDSQLite.ConexionSQLiteHelper;
import com.example.medicapp.BDSQLite.Constantes;
import com.example.medicapp.MainActivity;
import com.example.medicapp.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgregarMedico extends AppCompatActivity implements View.OnClickListener {

    Button btnFecha, btnHora, btnGuardar;
    EditText txtFecha, txtHora, txtNombreMedico, txtDomicilio, txtTel;
    int dia,mes,año,hora,minutos;
    MainActivity mn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medico);


        getSupportActionBar().setTitle("Agregar médico");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        btnGuardar = findViewById(R.id.btnGuardarMedicamento);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);
        txtNombreMedico = findViewById(R.id.txtMedico);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtTel = findViewById(R.id.txtTel);

        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);


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
                    //txtFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
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
                    txtHora.setText(hourOfDay+":"+minute+":"+"00");
                }
            },hora,minutos,false);
            timerPickerDialog.show();
        }

        if (v==btnGuardar){
            try {
                agregarMedicoSQL();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void agregarMedicoSQL() throws ParseException {

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_medicapp",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String sDate1=txtFecha.getText().toString();

        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date date1=formatter1.parse(sDate1);






        String insert="INSERT INTO "+Constantes.TABLA_MEDICO+" ("+Constantes.NOMBRE_MEDICO+","+Constantes.DOMICILIO_MEDICO+","+Constantes.TELEFONO_MEDICO+","+Constantes.FECHA_CITA+","+Constantes.HORA_CITA+") " +
                "VALUES ('"+txtNombreMedico.getText().toString()+"','"+txtDomicilio.getText().toString()+"','"+txtTel.getText().toString()+"','"+ formatter1.format(date1)+"', '"+txtHora.getText().toString()+"')";

        db.execSQL(insert);

        Toast.makeText(getApplicationContext(),"Cita médica agregada correctamente",Toast.LENGTH_SHORT).show();

        db.close();

        txtNombreMedico.getText().clear();
        txtDomicilio.getText().clear();
        txtTel.getText().clear();
        txtFecha.getText().clear();
        txtHora.getText().clear();

    }

    private void agregarMedico() {

       ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_medicapp", null, 1);

       SQLiteDatabase db=conn.getWritableDatabase();

       ContentValues values=new ContentValues();
       values.put(Constantes.NOMBRE_MEDICO, txtNombreMedico.getText().toString());
       values.put(Constantes.DOMICILIO_MEDICO, txtDomicilio.getText().toString());
       values.put(Constantes.TELEFONO_MEDICO, txtTel.getText().toString());
       values.put(Constantes.FECHA_CITA, txtFecha.getText().toString());
       values.put(Constantes.HORA_CITA, txtHora.getText().toString());


       Long idResultante = db.insert(Constantes.TABLA_MEDICO, Constantes.NOMBRE_MEDICO,values);

       Toast.makeText(getApplicationContext(), "nombre medico: " +idResultante,Toast.LENGTH_SHORT).show();
       db.close();

       Toast.makeText(getApplicationContext(),"xd",Toast.LENGTH_SHORT).show();
       
    }

}
