package com.example.medicapp;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationChannelExtender extends Application {
    public static final String Canal_1_ID="Notificaciones Médicas";
    @Override
    public void onCreate() {
        super.onCreate();

        crearCanales();
    }

    private void  crearCanales(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel ch1= new NotificationChannel(
                    Canal_1_ID,
                    "Notificaciones de Alarmas",
                    NotificationManager.IMPORTANCE_HIGH
            );
            ch1.enableVibration(true);
            ch1.setDescription("Tienes una alarma programada");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(ch1);
        }
    }
}