package com.example.esearch.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {


    public static  String getDados(String uri)  {
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(uri);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

            String linha;

            while ((linha = bufferedReader.readLine()) != null){
                    stringBuilder.append(linha+"\n");
            }
            return stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
