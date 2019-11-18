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
                .inflate(R.layout.item_list, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new MedicamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MedicamentoViewHolder holder, int position) {
        holder.txtNombreAlarma.setText(listaAlarma.get(position).getNombreAlarma());
        holder.txtHoraAlarma.setText(listaAlarma.get(position).getHoraAlarma());
    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }

    public class MedicamentoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlarma,txtHoraAlarma;
        ImageView foto;
        public MedicamentoViewHolder(View itemView) {
            super(itemView);
            txtNombreAlarma= (TextView) itemView.findViewById(R.id.idNombreAlarma);
            txtHoraAlarma= (TextView) itemView.findViewById(R.id.idHoraAlarma);
        }
    }
}
