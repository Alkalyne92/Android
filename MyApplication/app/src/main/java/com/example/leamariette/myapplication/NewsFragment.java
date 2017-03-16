package com.example.leamariette.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by leamariette on 15/03/2017.
 */

public class NewsFragment extends Fragment {

    public static NewsFragment newInstance(News news) {
        Bundle args = new Bundle();
        args.putParcelable("news", news);
        
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webarticle, container, false); // Webview
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState); // afficher dans la webview ton contenu

        News news = getArguments().getParcelable("news");
        // afficher dans la Webview

        String html = "<html><head></head><body>" +
                "<h2>" + news.getArticletext() + "</h2>" +
                "<h4>" + news.getInfostext() + "</h2>" +
                "</body></html>";

        //CardView displayNews = (CardView) findViewById(R.id.)


        WebView webView = (WebView) view.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInterface(), "Android");

        webView.loadData(html, "text/html", "utf-8");

    }


}



