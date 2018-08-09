package com.example.garik.assignment1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.garik.assignment1.Adapters.CatalogAdapter;
import com.example.garik.assignment1.R;
import com.example.garik.assignment1.databinding.CatalogFragmentBinding;


/**
 * Created by GaRiK on 02.08.2018.
 */

public class CatalogFragment extends Fragment {

    public static final String POSITION_KEY="POSITION_KEY";


    private RecyclerView recyclerView;
    public static CatalogFragment newInstance(int position) {

        CatalogFragment fragment = new CatalogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION_KEY,position+1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CatalogFragmentBinding binding=CatalogFragmentBinding.inflate(inflater,container,false);
        recyclerView=binding.catalogItemContainer;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CatalogAdapter(getContext()));
        return binding.getRoot();
    }
}
