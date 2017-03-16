package com.example.leamariette.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }



    public class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 5;
        }
        @Override
        public Fragment getItem(int position) {
            return new ListFragment();
        }

        @Override
        public String getPageTitle(int position) {
            return "Cochon Pôl";
        }
    }

}



