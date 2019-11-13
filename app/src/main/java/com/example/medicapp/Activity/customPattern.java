package com.example.medicapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.medicapp.MainActivity;
import com.example.medicapp.Activity.Login;
import com.example.medicapp.R;


import java.util.List;

public class customPattern extends AppCompatActivity {

    PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pattern);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("password", PatternLockUtils.patternToString(mPatternLockView, pattern));
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onCleared() {

            }
        });

    }
}
