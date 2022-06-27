package com.example.esearch.Model;

public class CategoryDomain {
    private String title;
    private int miniatura;

    public CategoryDomain(String title, int miniatura) {
        this.title = title;
        this.miniatura = miniatura;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMiniatura() {return miniatura;}

    public void setMiniatura(int miniatura) {this.miniatura = miniatura;}
}
