package com.example.esearch.Helper;

import android.os.AsyncTask;

import com.example.esearch.Model.Produtos;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, Produtos> {

    private String titleProduto;

    public HttpService(String titleProduto) {
        this.titleProduto = titleProduto;
    }

    @Override
    protected Produtos doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();


        try {
            URL url = new URL("https://192.168.0.108/apif/v1/Api.php?apicall=getprodutos");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(resposta.toString(), (Type) Produtos.class);
    }
}
