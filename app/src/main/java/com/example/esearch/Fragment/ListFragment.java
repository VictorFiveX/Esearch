package com.example.esearch.Fragment;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.esearch.Activity.ListaActivity;
import com.example.esearch.Activity.LoginActivity;
import com.example.esearch.Adapter.CategoryAdapter;
import com.example.esearch.Adapter.ListaAdapter;
import com.example.esearch.Model.CategoryDomain;
import com.example.esearch.Model.Lista;
import com.example.esearch.R;
import com.example.esearch.SQLite.DB;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private SQLiteDatabase.CursorFactory MODE_PRIVATE = null;
    private RecyclerView.Adapter adapt;
    private RecyclerView reclista;
    private TextView salve,salve1;
    private CardView card_fake;
    private ImageView add,open;
    private EditText edtnome;
    private Context mContext;
    public ArrayList<Integer> arrayIds;
    private SQLiteDatabase db;
    SharedPreferences sharedPreferences;
    private Lista list;
    private ArrayList<Lista> listas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        sharedPreferences = getContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Visibility","invisible");
        editor.commit();
        editor.apply();





        card_fake = view.findViewById(R.id.card_fake);
        salve = view.findViewById(R.id.salve);

        salve1 = view.findViewById(R.id.salve1);
        open = view.findViewById(R.id.open);



        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ListaActivity.class);
                startActivity(intent);


            }
        });

        add = view.findViewById(R.id.plusCardBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(getLayoutInflater().inflate(R.layout.alertdialog, null));
                builder.setTitle("Digite o nome da lista:");

                builder.setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                edtnome = ((Dialog) dialog).findViewById(R.id.edtDlista);
                                String nomelista = edtnome.getText().toString().trim();
                                salve1.setText(nomelista);
                                card_fake.setVisibility(View.VISIBLE);


                                sharedPreferences = getContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
                                SharedPreferences.Editor edito = sharedPreferences.edit();
                                edito.putString("Nomelista",nomelista);
                                edito.commit();
                                edito.apply();



                                sharedPreferences = getContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("Visibility","VISIBLE");
                                editor.commit();
                                editor.apply();

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder.create().show();
            }
        });


        return view;

    }







}



