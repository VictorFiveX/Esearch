package com.example.esearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esearch.Model.Produtos;
import com.example.esearch.R;
import com.example.esearch.SQLite.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, mercado1, mercado2, mercado3;
    private ImageView plusBtn, minusBtn, picFood;
    private Produtos object;
    int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }
    private void getBundle() {
        object = (Produtos) getIntent().getSerializableExtra("object");

//        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(picFood);
        picFood.setImageResource(object.getImageview());
        titleTxt.setText(object.getNomeMercado());
        feeTxt.setText("$" + object.getPreco());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        mercado1.setText(object.getMercado1());
        mercado2.setText(object.getMercado2());
        mercado3.setText(object.getMercado3());


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);
        mercado1=findViewById(R.id.mercado1);
        mercado2=findViewById(R.id.mercado2);
        mercado3=findViewById(R.id.mercado3);
    }
}