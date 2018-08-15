package com.example.garik.assignment1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.Items.CatalogItemList;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by GaRiK on 15.08.2018.
 */

@RunWith(AndroidJUnit4.class)
public class CatalogTest {
    private static CatalogItemList itemList;
    private static Context context;
    private static List<CatalogItem> catalogItems;


    public CatalogTest() {

        context = InstrumentationRegistry.getTargetContext();
        itemList = new CatalogItemList(context);

    }


    @Test
    public void testItemNames(){
        catalogItems =itemList.getCatalogItems();
        List<String> historyItemNames=new ArrayList<>();
        List<String> expected= Arrays.asList("Beeline","UMS","Uzmobile","Ucell","OLX","Perfectum Mobile","Black Star Wear");
        for (CatalogItem item: catalogItems) {
            historyItemNames.add(item.getName());
        }
        assertThat(expected,is(historyItemNames));
    }
    @Test
    public void testItemDescriptions(){
        catalogItems =itemList.getCatalogItems();
        List<String> historyItemDescriptions=new ArrayList<>();
        List<String> expected=Arrays.asList("Мобильные операторы","Мобильные операторы","Мобильные операторы","Мобильные операторы","Доска объявлений","Мобильные операторы","Интернет магазин");
        for (CatalogItem item: catalogItems) {
            historyItemDescriptions.add(item.getDescription());
        }
        assertThat(expected,is(historyItemDescriptions));
    }


    @Test
    public void testItemImageIds(){

        List<Integer> historyItemImageIds=new ArrayList<>();
        List<Integer> expected=Arrays.asList(R.drawable.beeline,R.drawable.ums, R.drawable.uzmobile, R.drawable.ucell, R.drawable.olx,R.drawable.perfectum, R.drawable.black_star);
        for (CatalogItem item: catalogItems) {
            historyItemImageIds.add(item.getImage());
        }
        assertThat(expected,is(historyItemImageIds));
    }




}