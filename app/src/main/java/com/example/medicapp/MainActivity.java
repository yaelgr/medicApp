package com.example.medicapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.medicapp.BDSQLite.ConexionSQLiteHelper;
import com.example.medicapp.fragment.ConfiguracionFragment;
import com.example.medicapp.fragment.InicioFragment;
import com.example.medicapp.fragment.MedicamentoFragment;
import com.example.medicapp.fragment.MedicoFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, InicioFragment.OnFragmentInteractionListener,
        MedicoFragment.OnFragmentInteractionListener, MedicamentoFragment.OnFragmentInteractionListener, ConfiguracionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_medicapp", null, 1);

       /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab_medico = (FloatingActionButton) findViewById(R.id.fab_medico);
        fab_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, AgregarMedico.class);
                startActivity(intent);
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        Fragment fragment = new InicioFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragment).commit();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment myfragment=null;
        boolean fragmentselected=false;

        if (id == R.id.nav_inicio) {
            myfragment=new InicioFragment();
            fragmentselected=true;}
        else if (id == R.id.nav_medico) {
            myfragment=new MedicoFragment();
            fragmentselected=true;
        } else if (id == R.id.nav_medicamento) {
            myfragment=new MedicamentoFragment();
            fragmentselected=true;
        } else if (id == R.id.nav_configuracion) {
            myfragment=new ConfiguracionFragment();
            fragmentselected=true;
        }
        if (fragmentselected==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,myfragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Código para las notificaciones Push:
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.ChannelName);
            String description = getString(R.string.ChannelDsc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CanalMedicapp", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CanalMedicapp" +
            "Alarmas de MedicApp")
            .setSmallIcon(R.drawable.ic_logo)
            .setContentTitle("MedicApp te recuerda")
            .setContentText("Hay una alarma para ti")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

}
