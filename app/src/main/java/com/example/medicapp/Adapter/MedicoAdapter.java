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

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_medico, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new MedicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicoViewHolder holder, int position) {
        holder.txtNombre.setText(listaAlarma.get(position).getNombre());
        holder.txtdomicilio.setText(listaAlarma.get(position).getDomicilio());
        holder.txttelefono.setText(listaAlarma.get(position).getTelefono());
        holder.txtfecha.setText(listaAlarma.get(position).getFecha());
        holder.txtHora.setText(listaAlarma.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return listaAlarma.size();
    }


    public class MedicoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtdomicilio, txttelefono, txtfecha, txtHora;
        ImageView foto;

        public MedicoViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.idNombre);
            txtdomicilio= (TextView) itemView.findViewById(R.id.idDomicilio);
            txttelefono= (TextView) itemView.findViewById(R.id.idTelefono);
            txtfecha= (TextView) itemView.findViewById(R.id.idFecha);
            txtHora= (TextView) itemView.findViewById(R.id.idHora);
        }
    }
}
