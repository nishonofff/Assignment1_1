package com.example.garik.assignment1.Activities;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.activeandroid.query.Select;
import com.example.garik.assignment1.DBactiveAndroid.CatalogModel;
import com.example.garik.assignment1.Fragments.CatalogFragment;
import com.example.garik.assignment1.R;
import com.example.garik.assignment1.databinding.ActivityMainBinding;
import com.example.garik.assignment1.databinding.NewItemDialogBinding;

import java.util.List;


/**
 * Created by nishonofff on 31.07.2018.
 */

public class MainActivity extends AppCompatActivity  {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    private View view;
    private AlertDialog alertDialog;

    private EditText name;
    private AutoCompleteTextView description;


    private CatalogFragment fragment;

    private String[] pageNames = {
            "Каталог"
            , "История"
    };
    private List<CatalogModel> modelList;

    private ActivityMainBinding binding;
    private NewItemDialogBinding dialogBinding;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /// Main activity layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewPager = binding.viewPager;
        tabLayout = binding.tabLayout;
        toolbar = binding.toolbar;



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        viewPager.setAdapter(new HistoryPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);


        ///  Alert dialog item view
        dialogBinding=NewItemDialogBinding.inflate(LayoutInflater.from(this));
        name=dialogBinding.dialogName;
        description=dialogBinding.dialogLastName;


        final String[] descriptions = {"Мобильные операторы","Доска объявлений","Интернет магазин"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,descriptions);
        description.setThreshold(1);
        description.setAdapter(adapter);

        description.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                if (descriptions.length> 0) {
                    // show all suggestions
                    if (!description.getText().toString().equals(""))
                        adapter.getFilter().filter(null);
                    description.showDropDown();
                }
                return false;
            }
        });

    }


    /**
     * Add new item floating action button listener
     */
    public void onAddClicked(View views){
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)

                    .setView(dialogBinding.getRoot())
                    .setCancelable(false);
            alertDialog = builder.create();
        }
        alertDialog.show();
    }
    /**
     * Save button
     */
    public void onSaveClicked(View views){
        CatalogModel model = new CatalogModel();
        model.name = name.getText().toString();
        model.description = description.getText().toString();

        int imageId = R.drawable.beeline;
        switch (name.getText().toString()) {

            case "Beeline": {
                imageId = R.drawable.beeline;
                break;
            }
            case "UMS": {
                imageId = R.drawable.ums;
                break;
            }
            case "Uzmobile": {
                imageId = R.drawable.uzmobile;
                break;
            }

            case "Ucell": {
                imageId = R.drawable.ucell;
                break;
            }
            case "OLX": {
                imageId = R.drawable.olx;
                break;
            }
            case "Perfectum Mobile": {
                imageId = R.drawable.perfectum;
                break;
            }
            case "Black Star Wear": {
                imageId = R.drawable.black_star;
                break;
            }
        }

        model.image = imageId;
        model.save();


        alertDialog.dismiss();
        modelList=new Select().from(CatalogModel.class).execute();
        fragment.refreshList(modelList);
    }
    /**
     * Cancel button
     */
    public void onCancelClicked(View views){
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        alertDialog.dismiss();
    }


    /**
     * HistoryPagerAdapter - adapter for viewPager
     */
    class HistoryPagerAdapter extends FragmentPagerAdapter {


        public HistoryPagerAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return fragment = CatalogFragment.newInstance(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageNames[position];
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
