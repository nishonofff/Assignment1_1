package com.example.garik.assignment1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.ViewGroup;


import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.Items.CatalogItemList;

import com.example.garik.assignment1.databinding.CatalogDataBinding;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaRiK on 31.07.2018.
 */

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {


    private Context context;
    private List<CatalogItem> catalogItems;


    public CatalogAdapter(Context context) {
        this.context = context;
        catalogItems=new ArrayList<>();
        catalogItems=new CatalogItemList(context).getCatalogItems();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        CatalogDataBinding dataBinding=CatalogDataBinding.inflate(inflater,parent,false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CatalogItem item=catalogItems.get(position);
        holder.bind(item);
}

    @Override
    public int getItemCount() {
        return catalogItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private CatalogDataBinding dataBinding;

        public ViewHolder(CatalogDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(CatalogItem item){
            this.dataBinding.setCatalogItem(item);
        }

        public CatalogDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}












