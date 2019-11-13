package com.example.medicapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.medicapp.MainActivity;
import com.example.medicapp.R;

import java.util.List;

public class Login extends AppCompatActivity {
    PatternLockView mPatternLockView;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        password = preferences.getString("password","0");

        mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if (password.equals(PatternLockUtils.patternToString(mPatternLockView, pattern))) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Login.this, "patrón incorrecto", Toast.LENGTH_SHORT).show();
                    mPatternLockView.clearPattern();
                }
            }

            @Override
            public void onCleared() {

            }
        });

    }
}
