package com.example.medicapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicapp.Activity.AgregarMedico;
import com.example.medicapp.Adapter.MedicoAdapter;
import com.example.medicapp.BDSQLite.ConexionSQLiteHelper;
import com.example.medicapp.BDSQLite.Constantes;
import com.example.medicapp.Class.MedicoVo;
import com.example.medicapp.MainActivity;
import com.example.medicapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MedicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerMedicos;
    ArrayList<MedicoVo> listaAlarma;
    FloatingActionButton fab_medico;
    ConexionSQLiteHelper conn;

    public MedicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicoFragment newInstance(String param1, String param2) {
        MedicoFragment fragment = new MedicoFragment();
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
        View vista = inflater.inflate(R.layout.fragment_medico, container, false);



        fab_medico = (FloatingActionButton) vista.findViewById(R.id.fab_medico);
        fab_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AgregarMedico.class));
            }
        });

        listaAlarma=new ArrayList<>();
        recyclerMedicos= (RecyclerView) vista.findViewById(R.id.recyclerMedico);
        recyclerMedicos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        MedicoAdapter adapter=new MedicoAdapter(listaAlarma);
        recyclerMedicos.setAdapter(adapter);


        return vista;
    }

    private void llenarLista() {
        /*listaAlarma.add(new MedicoVo("Medicamento1","paracetamol", "10/10/10", "11/11/11", "8"));*/

        conn = new ConexionSQLiteHelper(getContext(), "bd_medicapp", null,1);

        SQLiteDatabase db=conn.getReadableDatabase();

        MedicoVo medico=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Constantes.TABLA_MEDICO,null);

        while (cursor.moveToNext()) {
            medico = new MedicoVo();
            medico.setNombre(cursor.getString(1));
            medico.setDomicilio(cursor.getString(2));
            medico.setTelefono(cursor.getString(3));
            medico.setFecha(cursor.getString(4));
            medico.setHora(cursor.getString(5));

            listaAlarma.add(medico);

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
