package com.example.medicapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicapp.Class.MedicoVo;
import com.example.medicapp.R;

import java.util.ArrayList;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.MedicoViewHolder>{

    ArrayList<MedicoVo> listaAlarma;

    public MedicoAdapter(ArrayList<MedicoVo> listaAlarma) {
        this.listaAlarma = listaAlarma;
    }

    @Override
    public MedicoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new MedicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicoViewHolder holder, int position) {
        holder.txtNombreAlarma.setText(listaAlarma.get(position).getNombreAlarma());
        holder.txtHoraAlarma.setText(listaAlarma.get(position).getHoraAlarma());

    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }


    public class MedicoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreAlarma,txtHoraAlarma;
        ImageView foto;

        public MedicoViewHolder(View itemView) {
            super(itemView);
            txtNombreAlarma= (TextView) itemView.findViewById(R.id.idNombreAlarma);
            txtHoraAlarma= (TextView) itemView.findViewById(R.id.idHoraAlarma);
        }
    }
}
