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

        ///// CREER LE RECYCLER VIEW AVEC LA LISTE DES NEWS
        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            // Créer le RecyclerView
            RecyclerView rView = (RecyclerView) view.findViewById(android.R.id.list);
            // Lui assigner un LayoutManger
            rView.setLayoutManager(new LinearLayoutManager(getContext()));

            // Créer une liste de News
            ArrayList<News> newses = new ArrayList<>();
            // Y ajouter des News (items seuls)
            newses.add(new News("Super titre", "Super description", "Nouveautés", true));
            newses.add(new News("Un autre titre absolument génial", "Much description", "Nouveautés", true));
            newses.add(new News("Une dernière news, histoire de.", "What a description!", "Nouveautés", true));
            newses.add(new News("The last ouane", "What a i dont care!", "pouet", true));

            rView.setAdapter(new MyAdapter(newses, this));

        }


        ///// QUAND ON CLIQUE SUR L'UN DES ITEMS

        ///// Quand l'HeaderItem est cliqué.
        @Override
        public void onHeaderItemClicked(News news) {
            // Quand je clique, je créer une seconde activité.
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            // Je lui envoi l'objets "One_News" qui contient les paramètres (news) de la News en cours.
            intent.putExtra("OneNews", news);
            // Je start la seconde activité. = intent
            startActivity(intent);
        }

        ///// Quand l'Item est cliqué.
        @Override
        public void onItemClicked(News news) {
            // Quand je clique, je créer une seconde activité.
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            // Je lui envoi l'objets "One_News" qui contient les paramètres (news) de la News en cours.
            intent.putExtra("OneNews", news);
            // Je start la seconde activité. = intent
            startActivity(intent);


            /*
            // PARTAGER DU TEXTE
            //// Créer l'intent
            Intent i = new Intent(Intent.ACTION_SEND);
            //// Envoyer les l'url et démarrer l'activité
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "Si tu lis ce message, c'est que mon appli fonctionne :-)");
            startActivity(i);
            */

            /*
            // OUVRIR UNE ADRESSE DANS LE NAVIGATEUR
            //// Créer l'intent
            Intent i = new Intent(Intent.ACTION_VIEW);
            //// Envoyer les l'url et démarrer l'activité
            i.setData(Uri.parse("http://www.deezer.com/playlist/2697281324"));
            startActivity(i);
            */

            /*
            // Quand je clique, je créer une seconde activité.
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            // Je lui envoi l'objets "One_News" qui contient les paramètres (news) de la News en cours.
            intent.putExtra("OneNews", news);
            // Je start la seconde activité. = intent
            startActivity(intent);
            */
        }





}
