package com.example.esearch.SQLite;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.esearch.Activity.ListaActivity;
import com.example.esearch.Interface.ChangeNumberItemsListener;
import com.example.esearch.Model.Produtos;


import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(Produtos item) {
        ArrayList<Produtos> produtos = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNomeProduto().equals(item.getNomeProduto())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            produtos.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            produtos.add(item);
        }

        tinyDB.putListObject("CardList", produtos);
        Toast.makeText(context, "Adicionado a lista", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context.getApplicationContext(), ListaActivity.class);
        context.startActivity(intent);
    }

    public ArrayList<Produtos> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<Produtos> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<Produtos> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<Produtos> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getPreco() * listfood2.get(i).getNumberInCart());
        }
        return fee;
    }
}
