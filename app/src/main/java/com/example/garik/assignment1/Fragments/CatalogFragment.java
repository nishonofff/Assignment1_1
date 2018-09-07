package com.example.garik.assignment1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;
import com.example.garik.assignment1.Adapters.CatalogAdapter;
import com.example.garik.assignment1.DBactiveAndroid.CatalogModel;
import com.example.garik.assignment1.Items.CatalogItem;
import com.example.garik.assignment1.Items.CatalogItemList;
import com.example.garik.assignment1.R;
import com.example.garik.assignment1.databinding.CatalogFragmentBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nishonofff on 02.08.2018.
 */

public class CatalogFragment extends Fragment {

    /**
     * The constant POSITION_KEY.
     */
    public static final String POSITION_KEY="POSITION_KEY";

    private CatalogAdapter adapter;
    private RecyclerView recyclerView;

    private List<CatalogItem> catalogItems;
    private List<CatalogModel> modelList;

    /**
     * New instance catalog fragment.
     *
     * @param position the position
     * @return the catalog fragment
     */
    public static CatalogFragment newInstance(int position) {

        CatalogFragment fragment = new CatalogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION_KEY,position+1);
        fragment.setArguments(bundle);
        return fragment;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        catalogItems=new ArrayList<>();
        catalogItems=new CatalogItemList(getContext()).getCatalogItems();
        modelList=new Select().from(CatalogModel.class).execute();


        if(modelList.size()<=0){
            for (int i = 0; i < catalogItems.size(); i++) {

                CatalogModel model=new CatalogModel();
                model.name=catalogItems.get(i).getName();
                model.description=catalogItems.get(i).getDescription();
                model.image=catalogItems.get(i).getImage();
                model.save();


            }

        }

    }

    public void refreshList(List<CatalogModel> modelList){
        adapter.setModelList(modelList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CatalogFragmentBinding binding=CatalogFragmentBinding.inflate(inflater,container,false);
        recyclerView=binding.catalogItemContainer;
        adapter=new CatalogAdapter(getContext(),modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return binding.getRoot();

    }


    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
