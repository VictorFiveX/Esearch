package com.example.esearch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.esearch.Adapter.CartListAdapter;
import com.example.esearch.Fragment.HomeFragment;
import com.example.esearch.Fragment.SearchFragment;
import com.example.esearch.Interface.ChangeNumberItemsListener;
import com.example.esearch.R;
import com.example.esearch.SQLite.ManagementCart;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTxt;
    Button btnadd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        CalculateCart();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);



            }
        });


    }

    private void initView() {
        recyclerViewList = findViewById(R.id.view);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        btnadd = findViewById(R.id.btnadd);




    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);

    }

    private void CalculateCart() {


        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;

        totalFeeTxt.setText("$" + itemTotal);


    }
}