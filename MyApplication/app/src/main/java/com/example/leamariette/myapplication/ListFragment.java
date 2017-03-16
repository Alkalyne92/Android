package com.example.leamariette.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by leamariette on 15/03/2017.
 */

public class ListFragment extends Fragment implements ClickListener {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.list, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            RecyclerView rView = (RecyclerView) view.findViewById(android.R.id.list);
            rView.setLayoutManager(new LinearLayoutManager(getContext()));
            //rView.setAdapter(new MyAdapter(new String[]{"Coucou c'est moi Zelda", "Et moi 2", "Voiçi le 3em", "Le 4em", "Et le numéro complémentaire, le 5"}));

            // Créer une liste de News
            ArrayList<News> newses = new ArrayList<>();
            // Y ajouter des News (items seuls)
            newses.add(new News("Super titre", "Super description", "Nouveautés", true));
            newses.add(new News("Un autre titre absolument génial", "Much description", "Nouveautés", true));
            newses.add(new News("Une dernière news, histoire de.", "What a description!", "Nouveautés", true));
            newses.add(new News("The last ouane", "What a i dont care!", "pouet", true));

            rView.setAdapter(new MyAdapter(newses, this));

        }

        @Override
        // Quand l'HeaderItem est cliqué..
        public void onHeaderItemClicked(News news) {
            // Quand je clique, je créer une seconde activité.
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            // Je lui envoi l'objets "One_News" qui contient les paramètres (news) de la News en cours.
            intent.putExtra("OneNews", news);
            // Je start la seconde activité. = intent
            startActivity(intent);
        }

        @Override
        public void onItemClicked(News news) {
            // Quand je clique, je créer une seconde activité.
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            // Je lui envoi l'objets "One_News" qui contient les paramètres (news) de la News en cours.
            intent.putExtra("OneNews", news);
            // Je start la seconde activité. = intent
            startActivity(intent);
        }



}
