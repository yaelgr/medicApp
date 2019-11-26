package com.example.medicapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicapp.Activity.AgregarMedicamento;
import com.example.medicapp.Adapter.MedicamentoAdapter;
import com.example.medicapp.BDSQLite.ConexionSQLiteHelper;
import com.example.medicapp.BDSQLite.Constantes;
import com.example.medicapp.Class.MedicamentoVo;
import com.example.medicapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicamentoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MedicamentoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicamentoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerMedicamentos;
    ArrayList<MedicamentoVo> listaAlarma;
    FloatingActionButton fab_medicamento;
    ConexionSQLiteHelper conn;

    public MedicamentoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicamentoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicamentoFragment newInstance(String param1, String param2) {
        MedicamentoFragment fragment = new MedicamentoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_medicamento, container, false);



        fab_medicamento = (FloatingActionButton) vista.findViewById(R.id.fab_medicamento);
        fab_medicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AgregarMedicamento.class));
            }
        });
        listaAlarma=new ArrayList<>();
        recyclerMedicamentos= (RecyclerView) vista.findViewById(R.id.recyclerMedicamento);
        recyclerMedicamentos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        MedicamentoAdapter adapter=new MedicamentoAdapter(listaAlarma);
        recyclerMedicamentos.setAdapter(adapter);

        return vista;
    }

    private void llenarLista() {
        conn = new ConexionSQLiteHelper(getContext(), "bd_usuarios2", null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        MedicamentoVo medicamento=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Constantes.TABLA_MEDICAMENTO,null);

        while (cursor.moveToNext()) {
            medicamento = new MedicamentoVo();
            medicamento.setNombre(cursor.getString(0));
            medicamento.setNombreAlt(cursor.getString(1));
            medicamento.setFechaInicial(cursor.getString(2));
            medicamento.setFechaFinal(cursor.getString(3));
            medicamento.setFrecuencia(cursor.getString(4));

            listaAlarma.add(medicamento);
        }


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
