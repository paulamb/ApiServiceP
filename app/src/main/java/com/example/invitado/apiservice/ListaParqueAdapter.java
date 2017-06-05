package com.example.invitado.apiservice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.invitado.apiservice.models.Parque;

import java.util.ArrayList;

/**
 * Created by Invitado on 03/06/2017.
 */

public class ListaParqueAdapter extends RecyclerView.Adapter<ListaParqueAdapter.ViewHolder> {
    private ArrayList<Parque> dataset;

    private Context context;

    public ListaParqueAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parque, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Parque a = dataset.get(position);
        holder.nombre.setText(a.getNombreDelParque());
        holder.zonaEventos.setText(a.getZonaDeEventos().toString());
        holder.zonaverde.setText(a.getZonaVerde().toString());
        holder.arenal.setText(a.getArenal().toString());
        holder.juegosInfantiles.setText(a.getJuegosInfantiles().toString());
        holder.zonaWifi.setText(a.getZonaWiFi().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaParque(ArrayList<Parque> listaParque) {
        dataset.addAll(listaParque);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView zonaEventos;
        private TextView zonaverde;
        private TextView arenal;
        private TextView juegosInfantiles;
        private TextView zonaWifi;

        public ViewHolder(View itemView) {
            super(itemView);


            nombre = (TextView) itemView.findViewById(R.id.nombreparque);
            zonaEventos= (TextView) itemView.findViewById(R.id.zonaeven);
            zonaverde=(TextView) itemView.findViewById(R.id.zonaver);
            arenal=(TextView) itemView.findViewById(R.id.arenals);
            juegosInfantiles=(TextView) itemView.findViewById(R.id.juegos);
            zonaWifi=(TextView) itemView.findViewById(R.id.wifi);
        }
    }
}
