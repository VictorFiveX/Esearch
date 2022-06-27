package com.example.esearch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esearch.Model.Lista;
import com.example.esearch.R;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    private ArrayList<Lista> listas;
    private Context mContext;

    public ListaAdapter(ArrayList<Lista> listas, Context mContext) {
        this.listas = listas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_lista, parent, false);

        return new ViewHolder(inflate);


    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.ViewHolder holder, int position) {
                holder.Nomelista.setText(listas.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Nomelista;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Nomelista = itemView.findViewById(R.id.nomelitaview);
        }
    }
}
