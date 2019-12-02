package com.example.medicapp.BDSQLite;

public class Constantes {

    //Campos tabla medico
    public static final String TABLA_MEDICO="medico";
    public static final String NOMBRE_MEDICO="nombre_medico";
    public static final String DOMICILIO_MEDICO="domicilio_medico";
    public static final String TELEFONO_MEDICO="telefono_medico";
    public static final String FECHA_CITA="fecha_cita";
    public static final String HORA_CITA = "hora_cita";



    public static final String CREAR_TABLA_MEDICO="CREATE TABLE "+TABLA_MEDICO+
            "("+NOMBRE_MEDICO+" TEXT,"+
            DOMICILIO_MEDICO+" TEXT,"+
            TELEFONO_MEDICO+" TEXT,"+
            FECHA_CITA+" DATE,"+
            HORA_CITA+" TIME)";


    //Campos tabla Medicamento
    public static final String TABLA_MEDICAMENTO="medicamento";
    public static final String NOMBRE_MEDICAMENTO="nombre_medicamento";
    public static final String NOMBRE_ALTER="nombre_alternativo";
    public static final String FECHA_INICIAL="fecha_inicial";
    public static final String FECHA_FINAL="fecha_final";
    public static final String HORA_INICIO="hora_inicio";
    public static final String FRECUENCIA="frecuencia";

    public static final String CREAR_TABLA_MEDICAMENTO="CREATE TABLE "+TABLA_MEDICAMENTO+
            "("+NOMBRE_MEDICAMENTO+" TEXT,"+
            NOMBRE_ALTER+" TEXT,"+
            FECHA_INICIAL+" TEXT,"+
            FECHA_FINAL+" TEXT,"+
            HORA_INICIO+" TEXT,"+
            FRECUENCIA+" TEXT)";
}

