package com.example.esearch.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    
    public static final String DBNAME = "EsearchDB";
    public DBHelper(Context context){
        super(context, "EsearchDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE Produtos" +
//                        "(idproduto INTEGER PRIMARY KEY AUTOINCREMENT," +
//                        "nameP varchar(200) NOT NULL, " +
//                        "marcaP varchar(200) NOT NULL," +
//                        "preco decimal(8,2) NOT NULL," +
//                        "medida decimal(8,2) NOT NULL," +
//                        "tipomp varchar(200) NOT NULL," +
//                        "supermercado varchar(200)NOT NULL);");

        db.execSQL("CREATE TABLE Lista" +
                "(idlista INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomelista varchar(200) NOT NULL," +
                "idP INTEGER );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS lista;");
        onCreate(db);
    }


}
