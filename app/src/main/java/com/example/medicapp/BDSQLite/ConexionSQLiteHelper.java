package com.example.medicapp.BDSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_TABLA_MEDICO);
        db.execSQL(Constantes.CREAR_TABLA_MEDICAMENTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constantes.TABLA_MEDICO);
        db.execSQL("DROP TABLE IF EXISTS "+Constantes.TABLA_MEDICAMENTO);
        onCreate(db);

    }
}
