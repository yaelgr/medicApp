package com.example.medicapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.medicapp.MainActivity;
import com.example.medicapp.R;

import java.util.List;

import androidx.versionedparcelable.CustomVersionedParcelable;
import io.paperdb.Paper;

public class PatternLock extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_lock);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                String password = preferences.getString("password","0");
                if (password.equals("0")){
                    Intent intent= new Intent(getApplicationContext(), customPattern.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent= new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }
}
