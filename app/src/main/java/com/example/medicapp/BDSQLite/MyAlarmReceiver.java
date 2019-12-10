package com.example.medicapp.BDSQLite;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.medicapp.MainActivity;
import com.example.medicapp.R;

import java.util.Calendar;


public class MyAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    private NotificationManagerCompat notificationManager;
    private final int NOTIFICATION_ID = 1010;
    private ConexionSQLiteHelper admin;
    private Cursor fila;
    private SQLiteDatabase bd;
    private String alarma,descripcion,titulo;


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyTestService.class);
        context.startService(i);
        Calendar calendario = Calendar.getInstance();
        int hora, min,dia,mes,ano,seg;
        String cadenaF, cadenaH,fecha_sistema,hora_sistema;

        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH)+1;
        ano = calendario.get(Calendar.YEAR);
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND);
        fecha_sistema=dia+"/"+mes+"/"+ano;
        hora_sistema=hora+":"+min+":"+seg;
        admin = new ConexionSQLiteHelper(context, vars.bd, null, vars.version);
        bd = admin.getWritableDatabase();

        if(bd!=null) {
            fila = bd.rawQuery("SELECT * FROM medico WHERE fecha_cita='"+fecha_sistema+"' AND hora_cita= '"+hora_sistema+"'", null);
            if(fila.moveToFirst()){

                triggerNotification(context,calendario);
            }
            fila = bd.rawQuery("SELECT * FROM medicamento WHERE fecha_inicial='"+fecha_sistema+"' AND hora_inicio= '"+hora_sistema+"'", null);
            if(fila.moveToFirst()){

                triggerNotification(context,calendario);

            }
        }
        bd.close();
    }

    private void triggerNotification(Context contexto, Calendar ahora) {
        notificationManager= NotificationManagerCompat.from(contexto);
        Intent notificationIntent = new Intent(contexto, MainActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(contexto, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        long[] pattern = new long[]{2000, 1000, 2000};

        String title="MedicApp te recuerda";
        String message="Tiene una nueva notificación";
        Notification builder = new NotificationCompat.Builder(contexto, "Notificaciones Médicas")
                .setSmallIcon(R.drawable.ic_logo)
                .setContentTitle(title)
                .setContentText(message)
                .setVibrate(pattern)
                .setContentIntent(contentIntent)
                .setSound(defaultSound)
                .setWhen(ahora.getTimeInMillis())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .build();

        notificationManager.notify(1,builder);
    }

}
