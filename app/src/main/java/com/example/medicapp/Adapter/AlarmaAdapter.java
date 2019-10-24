package com.example.medicapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicapp.Class.AlarmaVo;
import com.example.medicapp.R;

import java.util.ArrayList;

public class AlarmaAdapter extends RecyclerView.Adapter<AlarmaAdapter.AlarmaViewHolder>{

        ArrayList<AlarmaVo> listaAlarma;

    public AlarmaAdapter(ArrayList<AlarmaVo> listaAlarma) {
        this.listaAlarma=listaAlarma;
    }

    @Override
    public AlarmaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new AlarmaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlarmaViewHolder holder, int position) {
        holder.txtNombreAlarma.setText(listaAlarma.get(position).getNombreAlarma());
        holder.txtHoraAlarma.setText(listaAlarma.get(position).getHoraAlarma());

    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }

    public class AlarmaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlarma,txtHoraAlarma;
        ImageView foto;

        public AlarmaViewHolder(View itemView) {
            super(itemView);
            txtNombreAlarma= (TextView) itemView.findViewById(R.id.idNombreAlarma);
            txtHoraAlarma= (TextView) itemView.findViewById(R.id.idHoraAlarma);
        }
    }
}
