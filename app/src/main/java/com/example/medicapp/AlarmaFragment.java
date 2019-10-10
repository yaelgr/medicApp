package com.example.medicapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlarmaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    RecyclerView recyclerPersonajes;
    ArrayList<AlarmaVo> listaAlarma;

    public AlarmaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmaFragment newInstance(String param1, String param2) {
        AlarmaFragment fragment = new AlarmaFragment();
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
        View vista = inflater.inflate(R.layout.fragment_alarma, container, false);
        listaAlarma=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) vista.findViewById(R.id.recyclerAlarma);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AlarmaAdapter adapter=new AlarmaAdapter(listaAlarma);
        recyclerPersonajes.setAdapter(adapter);

        return vista;
    }

    private void llenarLista() {
        listaAlarma.add(new AlarmaVo("alarma1","7:00 AM"));
        listaAlarma.add(new AlarmaVo("alarma2","8:00 AM"));
        listaAlarma.add(new AlarmaVo("alarma3","9:00 AM"));
        listaAlarma.add(new AlarmaVo("alarma4","10:00 AM"));
        listaAlarma.add(new AlarmaVo("alarma5","11:00 AM"));


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