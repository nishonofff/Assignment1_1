package com.example.garik.assignment1.Items;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaRiK on 03.08.2018.
 */

public class CatalogItemList {
    private List<CatalogItem> catalogItems;
    private String[] catalogItemNames;
    private String[] catalogItemDescriptions;
    private TypedArray catalogItemImages;
    private Context context;



    public CatalogItemList(Context context) {
        this.context=context;
        catalogItems=new ArrayList<>();
        catalogItemNames =context.getResources().getStringArray(R.array.catalog_item_names);
        catalogItemDescriptions =context.getResources().getStringArray(R.array.catalog_item_descriptions);
        catalogItemImages=context.getResources().obtainTypedArray(R.array.catalog_item_images);

        for (int i = 0; i < catalogItemNames.length; i++) {

            CatalogItem item=new CatalogItem(
                    catalogItemNames[i]
                    , catalogItemDescriptions[i]
                    ,catalogItemImages.getResourceId(i,0));

            catalogItems.add(item);
        }

    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setHistoryItems(List<CatalogItem> historyItems) {
        this.catalogItems = historyItems;
    }

}
