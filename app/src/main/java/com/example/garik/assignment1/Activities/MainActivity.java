package com.example.garik.assignment1.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.garik.assignment1.Fragments.CatalogFragment;
import com.example.garik.assignment1.R;


public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private String[] pageNames= {
            "Каталог"
            , "История"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        viewPager.setAdapter(new HistoryPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);

    }



    class HistoryPagerAdapter extends FragmentPagerAdapter{


        public HistoryPagerAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return CatalogFragment.newInstance(position);
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