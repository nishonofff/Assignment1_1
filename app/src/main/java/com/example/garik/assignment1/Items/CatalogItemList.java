package com.example.garik.assignment1.Items;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishonofff on 03.08.2018.
 */

public class CatalogItemList {
    private List<CatalogItem> catalogItems;
    private String[] catalogItemNames;
    private String[] catalogItemDescriptions;
    private TypedArray catalogItemImages;


    private Context context;


    /**
     * Constructor of CatalogItemList class, all initializations written here
     *
     * @param context the context
     */
    public CatalogItemList(Context context) {
        this.context=context;
        catalogItems=new ArrayList<>();
        catalogItemNames = context.getResources().getStringArray(R.array.catalog_item_names);
        catalogItemDescriptions =context.getResources().getStringArray(R.array.catalog_item_descriptions);
        catalogItemImages=context.getResources().obtainTypedArray(R.array.catalog_item_images);

        for (int i = 0; i < catalogItemNames.length; i++) {

            CatalogItem item=new CatalogItem(
                    catalogItemNames[i]
                    ,catalogItemDescriptions[i]
                    ,catalogItemImages.getResourceId(i,0));

            catalogItems.add(item);
        }

    }


    /**
     * @return list of CatalogItems as a List<CatalogItem>
     */
    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }
    /**
     * @param catalogItems the catalog items
     */
    public void setHistoryItems(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

}
