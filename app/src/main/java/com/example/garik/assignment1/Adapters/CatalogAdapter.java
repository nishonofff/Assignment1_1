package com.example.garik.assignment1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.ViewGroup;


import com.activeandroid.query.Select;
import com.example.garik.assignment1.DBactiveAndroid.CatalogModel;
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
    private List<CatalogModel> modelList;




    /**
     * Instantiates a new Catalog adapter.
     *
     * @param context the context
     */
    public CatalogAdapter(Context context, List<CatalogModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        CatalogDataBinding dataBinding=CatalogDataBinding.inflate(inflater,parent,false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CatalogModel model=modelList.get(position);
        holder.bind(model);
}


    public void setModelList(List<CatalogModel> modelList) {

        this.modelList=modelList;
        notifyItemInserted(modelList.size()-1);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
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
         * @param model the item
         */
        public void bind(CatalogModel model){
            this.dataBinding.setCatalogModel(model);
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












