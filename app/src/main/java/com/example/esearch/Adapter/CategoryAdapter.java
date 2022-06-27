package com.example.esearch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esearch.Model.CategoryDomain;
import com.example.esearch.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryDomain> categoryDomains;
    private View.OnClickListener listener;
    private Context mContext;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains, Context mContext) {
        this.categoryDomains = categoryDomains;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);
    }
    //Será realizada a montagem dos dados.

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //passando valores para o RecyclerView
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        holder.categoryPic.setImageResource(categoryDomains.get(position).getMiniatura());


    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);


        }

        @Override
        public void onClick(View v) {


        }
    }
}
