package com.example.garik.assignment1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.Items.CatalogItemList;
import com.example.garik.assignment1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaRiK on 31.07.2018.
 */

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {



    private List<CatalogItem> catalogItems;
    private Context context;




    public CatalogAdapter(Context context) {
        this.context = context;
        catalogItems=new ArrayList<>();
        catalogItems=new CatalogItemList(context).getCatalogItems();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.catalog_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.itemName.setText(catalogItems.get(position).getName());
        holder.itemDescription.setText(catalogItems.get(position).getDescription());

        Picasso.with(context)
                .load(catalogItems.get(position).getImage())
                .into(holder.itemImage);
}

    @Override
    public int getItemCount() {
        return catalogItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        ImageView itemImage;
        TextView itemName;
        TextView itemDescription;



        public ViewHolder(View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.item_image);
            itemName=itemView.findViewById(R.id.item_name);
            itemDescription=itemView.findViewById(R.id.item_description);
        }
    }
}












