package com.example.medicapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicapp.Class.InicioVo;
import com.example.medicapp.R;

import java.util.ArrayList;

public class InicioAdapter extends RecyclerView.Adapter<InicioAdapter.InicioViewHolder> {


    public InicioAdapter(ArrayList<InicioVo> listaAlarma) {
        this.listaAlarma = listaAlarma;
    }

    ArrayList<InicioVo> listaAlarma;

    @Override
    public InicioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new InicioViewHolder(view);
    }


    @Override
    public void onBindViewHolder(InicioViewHolder holder, int position) {
        holder.txtNombreAlarma.setText(listaAlarma.get(position).getNombreAlarma());
        holder.txtHoraAlarma.setText(listaAlarma.get(position).getHoraAlarma());
    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }

    public class InicioViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlarma,txtHoraAlarma;
        ImageView foto;
        public InicioViewHolder(View itemView) {
            super(itemView);
            txtNombreAlarma= (TextView) itemView.findViewById(R.id.idNombreAlarma);
            txtHoraAlarma= (TextView) itemView.findViewById(R.id.idHoraAlarma);
        }
    }
}
