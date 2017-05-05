package com.example.leamariette.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        ///// AFFICHER UNE NOTIFICATION
        // Ajouter un notification Manager
        NotificationManager nm;
        nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Construire la notification + son contenu
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder
                        .setSmallIcon(R.drawable.cochon)
                        .setContentTitle("Voici une notification")
                        .setContentText("Hola que tal ?");

        // Attribuer un ID à la notif + construire la notif
        nm.notify((int) System.currentTimeMillis(), builder.build());
    }


    ///// PAGE ADAPTER
    public class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 2;
        }
        // Aller chercher le fragment LIST
        @Override
        public Fragment getItem(int position) {
            return new ListFragment();
        }

        @Override
        public String getPageTitle(int position) {
            return "Onglet";
        }
    }






}



