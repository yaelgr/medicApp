package com.example.medicapp.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.medicapp.Activity.customPattern;
import com.example.medicapp.R;

public class DialogFrag_Google extends DialogFragment {

    private static final String TAG = "DialogFragGoogle";




    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.dialogfrag_google, container, false);


        return view;

    }

}
