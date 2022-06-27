package com.example.esearch.Fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.esearch.Adapter.ProdutosAdapter;
import com.example.esearch.Api.ConsumirAPI;
import com.example.esearch.Helper.Conexao;
import com.example.esearch.Model.CategoryDomain;
import com.example.esearch.Model.Produtos;
import com.example.esearch.R;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private EditText editSearch;


    private RecyclerView.Adapter produ;
    private RecyclerView recprod;

    private Context nContext;
    private ArrayList<Produtos> produtos;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        editSearch = view.findViewById(R.id.editNomeProduto);
        editSearch.requestFocus();

        recprod = view.findViewById(R.id.Salve_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recprod.setLayoutManager(linearLayoutManager);

        ArrayList<Produtos> produtos = new ArrayList<>();


        produtos.add(new Produtos("Arroz Tipo 1 CAMIL\nPacote 1kg","Extra",5.79,"Arroz Agulhinha Tipo 1 CAMIL Pacote 1kg",R.drawable.parrozcamil1kg,"Ricoy-------$6.00","Carrefour-------$6.20","Sonda-------$6.70"));
        produtos.add(new Produtos("Feijão Carioca\nComum Tipo 1\nCamil 1kg","Extra",17.49,"Feijão Carioca Comum Tipo 1 Grãos Selecionados Camil 1kg",R.drawable.pfeijaocamil,"Ricoy-------$18.00","Carrefour-------$18.70","Sonda-------$19.30"));
        produtos.add(new Produtos("Café 3 corações\nExtra Forte\nVácuo 500g","Extra",24.00,"Café 3 corações Extra Forte Vácuo 500g",R.drawable.pcafe,"Ricoy-------$24.70","Carrefour-------$25.00","Sonda-------$25.39"));
        produtos.add(new Produtos("Açúcar Refinado\n1kg União","Extra",10.74,"Açúcar Refinado 1kg União\n",R.drawable.pacucar,"Ricoy-------$11.10","Carrefour-------$11.30","Sonda-------$11.35"));
        produtos.add(new Produtos("Sal Refinado CISNE\nTradicional\nPacote 1Kg","Extra",3.55,"Sal Refinado CISNE Tradicional Pacote 1Kg",R.drawable.psal,"Ricoy-------$4.10","Carrefour-------$4.22","Sonda-------$4.50"));

        produ = new ProdutosAdapter(produtos,nContext);
        recprod.setAdapter(produ);

        return view;
    }

    }
















