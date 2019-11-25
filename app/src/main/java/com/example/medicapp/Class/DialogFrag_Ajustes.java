package com.example.medicapp.Class;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicapp.R;

public class DialogFrag_Ajustes extends DialogFragment {

    private static final String TAG = "DialogFragAjustes";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.dialogfrag_ajustes, container, false);
        return view;

    }
}
