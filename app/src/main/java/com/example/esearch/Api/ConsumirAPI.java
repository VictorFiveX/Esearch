package com.example.esearch.Api;

import com.example.esearch.Model.Produtos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsumirAPI {

    public static ArrayList<Produtos> JsonDados(String conteudo) {

        try {
            ArrayList<Produtos> Dados = new ArrayList<>();
            JSONArray  jsonArray= null;
            JSONObject jsonObject = null;


            jsonArray = new JSONArray(conteudo);

            for (int i = 0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

               // Produtos itensDomain = new Produtos(conteudo);
                //itensDomain.setTitleProduto(jsonObject.getString(""));

              //  Dados.add(itensDomain);


            }
            return Dados;


        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }




    }

}
