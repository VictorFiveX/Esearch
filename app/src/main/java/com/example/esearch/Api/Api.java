package com.example.esearch.Api;

public class Api {

    private static final String ROOT_URL = "https://192.168.0.108/apif/v1/Api.php?apicall=";

    public static final String URL_CREATE_Usuario = ROOT_URL + "createusuario";
    public static final String URL_READ_Usuario = ROOT_URL + "getusuarios";
    public static final String URL_logar_Usuario = ROOT_URL + "logar";
    public static final String URL_READ_Produto = ROOT_URL + "getprodutos";
    public static final String URL_CREATE_Lista = ROOT_URL + "createlista";
    public static final String URL_READ_Lista = "https://192.168.0.108/apif/v1/Api.php?apicall=getlistas";
    public static final String URL_READ_HEROES = "http://192.168.0.108/HeroApi/v1/Api.php?apicall=getheroes";
}
