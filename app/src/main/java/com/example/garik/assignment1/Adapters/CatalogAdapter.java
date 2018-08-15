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
 * Created by nishonofff on 31.07.2018.
 */
public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {


    private Context context;
    private List<CatalogItem> catalogItems;


    /**
     * Instantiates a new Catalog adapter.
     *
     * @param context the context
     */
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

    /**
     * The type View holder.
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        private CatalogDataBinding dataBinding;

        /**
         * Instantiates a new View holder.
         *
         * @param dataBinding the data binding
         */
        public ViewHolder(CatalogDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        /**
         * Bind.
         *
         * @param item the item
         */
        public void bind(CatalogItem item){
            this.dataBinding.setCatalogItem(item);
        }

        /**
         * Gets data binding.
         *
         * @return the data binding
         */
        public CatalogDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}












