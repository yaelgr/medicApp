package com.example.medicapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicapp.Class.MedicamentoVo;
import com.example.medicapp.R;

import java.util.ArrayList;

public class MedicamentoAdapter extends RecyclerView.Adapter<MedicamentoAdapter.MedicamentoViewHolder> {


    public MedicamentoAdapter(ArrayList<MedicamentoVo> listaAlarma) {
        this.listaAlarma = listaAlarma;
    }

    ArrayList<MedicamentoVo> listaAlarma;

    @Override
    public MedicamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_medicamento, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new MedicamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MedicamentoViewHolder holder, int position) {
        holder.txtNombre.setText(listaAlarma.get(position).getNombre());
        holder.txtNombreAlt.setText(listaAlarma.get(position).getNombreAlt());
        holder.txtFechaInicial.setText(listaAlarma.get(position).getFechaInicial());
        holder.txtFechaFinal.setText(listaAlarma.get(position).getFechaFinal());
        holder.txtHoraInicio.setText(listaAlarma.get(position).getHoraInicio());
        holder.txtFrecuencia.setText(listaAlarma.get(position).getFrecuencia());
    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }

    public class MedicamentoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtNombreAlt, txtFechaInicial, txtFechaFinal, txtFrecuencia, txtHoraInicio;

        public MedicamentoViewHolder(View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.idNombreMedicamento);
           txtNombreAlt= itemView.findViewById(R.id.idNombreAlter);
            txtFechaInicial= itemView.findViewById(R.id.idFechaInicial);
            txtFechaFinal= itemView.findViewById(R.id.idFechaFinal);
            txtHoraInicio= itemView.findViewById(R.id.idHorainicial);
            txtFrecuencia= itemView.findViewById(R.id.idFrecuencia);
        }
    }
}
