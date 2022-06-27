package com.example.esearch.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.esearch.Adapter.CategoryAdapter;
import com.example.esearch.Adapter.SliderAdapter;
import com.example.esearch.Model.CategoryDomain;
import com.example.esearch.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView categoria;
    private ArrayList<CategoryDomain> categoryList;
    private Context mContext;
    private SearchFragment searchFragment = new SearchFragment();
    private int[] images = {R.drawable.oferta,R.drawable.oferta1,R.drawable.oferta2,R.drawable.oferta3};
    private SliderView sliderView;
    private EditText edtsearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //declarando a variavel xml enviando para o java
        categoria = view.findViewById(R.id.Rec_Catego);

        //Instânciando o adaptador com os valores necessários
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        categoria.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        // adicionando itens no array
        categoryList.add(new CategoryDomain("Extra", R.drawable.mextra));
        categoryList.add(new CategoryDomain("Ricoy", R.drawable.mricoy));
        categoryList.add(new CategoryDomain("Carrefour", R.drawable.mcarrefuor));
        categoryList.add(new CategoryDomain("Assaí", R.drawable.massai));
        categoryList.add(new CategoryDomain("Pão de Açúcar", R.drawable.mpaodeacar));
        categoryList.add(new CategoryDomain("Sonda", R.drawable.msonda));
        categoryList.add(new CategoryDomain("Walmart", R.drawable.mwalmart));

        adapter = new CategoryAdapter(categoryList, mContext);
        categoria.setAdapter(adapter);


        sliderView = view.findViewById(R.id.img_banner);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        edtsearch = view.findViewById(R.id.editSearch);
        edtsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();

            }
        });

        return view;
    }
}