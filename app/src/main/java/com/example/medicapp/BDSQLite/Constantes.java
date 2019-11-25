package com.example.medicapp.BDSQLite;

public class Constantes {

    //Campos tabla medico
    public static final String TABLA_MEDICO="medico";
    public static final String ID_MEDICO= "idMedico";
    public static final String NOMBRE_MEDICO="nombreMedico";
    public static final String TELEFONO_MEDICO="telefonoMedico";
    public static final String DOMICILIO_MEDICO="DomicilioMedico";
    public static final String FECHA_CITA="fechaCita";
    public static final String HORA_CITA = "horaCita";

    public static final String CREAR_TABLA_MEDICO="CREATE TABLE" +TABLA_MEDICO+" ("+ID_MEDICO+" INTEGER, "+NOMBRE_MEDICO+" TEXT," +
            " "+TELEFONO_MEDICO+" TEXT, "+DOMICILIO_MEDICO+" TEXT, "+FECHA_CITA+" DATE, "+HORA_CITA+" TIME)";
}
