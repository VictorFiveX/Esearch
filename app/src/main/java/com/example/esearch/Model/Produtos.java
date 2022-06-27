package com.example.esearch.Model;

import java.io.Serializable;

public class Produtos implements Serializable {

    private String NomeProduto;
    private String NomeMercado;
    private Double preco;
    private String description;
    private String mercado1, mercado2, mercado3;
    private int numberInCart;
    private int Imageview;

    public Produtos(String nomeProduto, String nomeMercado, Double preco, String description, int imageview, String mercado1, String mercado2, String mercado3) {

        this.NomeProduto = nomeProduto;
        this.NomeMercado = nomeMercado;
        this.Imageview = imageview;
        this.preco = preco;
        this.description = description;
        this.mercado1 =mercado1;
        this.mercado2 =mercado2;
        this.mercado3 =mercado3;


    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public String getNomeMercado() {
        return NomeMercado;
    }

    public void setNomeMercado(String nomeMercado) {
        NomeMercado = nomeMercado;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getMercado1() {
        return mercado1;
    }

    public void setMercado1(String mercado1) {
        this.mercado1 = mercado1;
    }

    public String getMercado2() {
        return mercado2;
    }

    public void setMercado2(String mercado2) {
        this.mercado2 = mercado2;
    }

    public String getMercado3() {
        return mercado3;
    }

    public void setMercado3(String mercado3) {
        this.mercado3 = mercado3;
    }

    public int getImageview() {
        return Imageview;
    }

    public void setImageview(int imageview) {
        Imageview = imageview;
    }
}
