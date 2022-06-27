package com.example.esearch.SQLite;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class DB {
    private static final SQLiteDatabase.CursorFactory MODE_PRIVATE = null;
    private SQLiteDatabase db;
    public ArrayList<Integer> arrayIds;

    public void onCreate(SQLiteDatabase db) {

        criarBancoDados();

    }

    public void criarBancoDados(){
        try {
            openOrCreateDatabase("Esearch", MODE_PRIVATE, null);

            db.execSQL("CREATE TABLE lista" +
                    "(idlista INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nomelista varchar(200) NOT NULL);");

            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarDados(){
        try {
            arrayIds = new ArrayList<>();
            db = openOrCreateDatabase("Esearch", MODE_PRIVATE, null);
            Cursor meuCursor = db.rawQuery("SELECT idlista, nomelista FROM lista", null);
            ArrayList<String> linhas = new ArrayList<String>();

//            ArrayAdapter meuAdapter = new ArrayAdapter<String>(
//                    Context,
//                    android.R.layout.simple_list_item_1,
//                    linhas,
//                    android.R.id.text1
//            );
//            listViewDados.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while(meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                arrayIds.add(meuCursor.getInt(0));
                meuCursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void inserirDadosTemp(){
        try{
            db = openOrCreateDatabase("Esearch", MODE_PRIVATE, null);
            String sql = "INSERT INTO lista (nomelista) VALUES (?)";
            SQLiteStatement stmt = db.compileStatement(sql);

            stmt.bindString(1,"Coisa 1");
            stmt.executeInsert();

            stmt.bindString(1,"Coisa abc");
            stmt.executeInsert();

            stmt.bindString(1,"Coisa Terceira");
            stmt.executeInsert();

            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
