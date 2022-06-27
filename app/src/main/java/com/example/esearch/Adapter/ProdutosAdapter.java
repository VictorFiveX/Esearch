package com.example.esearch.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.esearch.Activity.ShowDetailActivity;
import com.example.esearch.Model.Produtos;
import com.example.esearch.R;

import java.util.ArrayList;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolder>{
    private ArrayList<Produtos> produtos;
    private Context nContext;


    //Construtor da classe

    public ProdutosAdapter(ArrayList<Produtos> produtos, Context nContext) {
        this.produtos = produtos;
        this.nContext = nContext;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_itens, parent, false);

        return new ViewHolder(inflate);
    }
    //Será realizada a montagem dos dados.

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //passando valores para o RecyclerView
        holder.nomeproduto.setText(produtos.get(position).getNomeProduto());
        holder.nomemercado.setText(produtos.get(position).getNomeMercado());
        holder.preco.setText(String.valueOf(produtos.get(position).getPreco()));
        holder.imgproduto.setImageResource(produtos.get(position).getImageview());

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", produtos.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });





    }




    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeproduto;
        TextView nomemercado;
        TextView preco;
        ImageView addBtn;
        ImageView imgproduto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           nomeproduto = itemView.findViewById(R.id.NomeProd);
           nomemercado = itemView.findViewById(R.id.mercado);
           preco = itemView.findViewById(R.id.precoUnico);
            addBtn = itemView.findViewById(R.id.plusCardbtn);
            imgproduto = itemView.findViewById(R.id.picCart);
        }
    }
}
