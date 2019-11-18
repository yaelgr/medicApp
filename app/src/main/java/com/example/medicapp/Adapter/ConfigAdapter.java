package com.example.medicapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicapp.Class.ConfigVo;
import com.example.medicapp.R;

import java.util.ArrayList;

public class ConfigAdapter extends RecyclerView.Adapter<ConfigAdapter.ConfigViewHolder>  {

    public ConfigAdapter(ArrayList<ConfigVo> listaAlarma) {
        this.listaAlarma = listaAlarma;
    }

    ArrayList<ConfigVo> listaAlarma;

    @Override
    public ConfigViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new ConfigViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConfigViewHolder holder, int position) {
        holder.txtNombreAlarma.setText(listaAlarma.get(position).getTitulo());
        holder.txtHoraAlarma.setText(listaAlarma.get(position).getDesc());
        holder.imagen.setImageResource(listaAlarma.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }

    public class ConfigViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlarma,txtHoraAlarma;
        ImageView imagen;
        public ConfigViewHolder(View itemView) {
            super(itemView);
            txtNombreAlarma= (TextView) itemView.findViewById(R.id.idNombreAlarma);
            txtHoraAlarma= (TextView) itemView.findViewById(R.id.idHoraAlarma);
            imagen= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
