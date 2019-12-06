package com.example.medicapp.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicapp.R;

public class DialogFrag_Historial extends DialogFragment {

    private static final String TAG = "DialogFragHistorial";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.dialogfrag_historial, container, false);
        return view;

    }
}
