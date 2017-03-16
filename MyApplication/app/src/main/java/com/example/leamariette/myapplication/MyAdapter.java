package com.example.leamariette.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by leamariette on 14/03/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<News> values;
    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;

    private final ClickListener listener;

    public MyAdapter(ArrayList<News> values, ClickListener listener) {
        this.values = values;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        // Si sa position est 0, je retourne un type HEADER (en avant), sinon je retourne un type normal (1)

        if (position == 0)
            {
                return TYPE_HEADER;
            }
        return TYPE_ITEM;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.firstarticle, parent, false), listener);
        } else {
            return new ItemViewHolder(inflater.inflate(R.layout.singlearticle, parent, false), listener);
        }

    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder,
                                 int position) {

        News news = values.get(position);

        int viewType = getItemViewType(position);
        if (viewType == TYPE_HEADER) {
            ((HeaderViewHolder)holder).bindValue(news);
        } else {
            ((ItemViewHolder)holder).bindValue(news);
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }



    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView articletext;
        private TextView infostext;
        private ClickListener listener;

        ItemViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            articletext = (TextView) itemView.findViewById(R.id.article_text);
            infostext = (TextView) itemView.findViewById(R.id.infos_text);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        public void bindValue(News value) {
            articletext.setText(value.getArticletext());
            infostext.setText(value.getInfostext());
            itemView.setTag(value);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClicked((News) itemView.getTag());
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView articletext;
        private TextView infostext;
        private ClickListener listener;

        HeaderViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            articletext = (TextView) itemView.findViewById(R.id.article_text);
            infostext = (TextView) itemView.findViewById(R.id.infos_text);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindValue(News value) {
            articletext.setText(value.getArticletext());
            infostext.setText(value.getInfostext());
            itemView.setTag(value);
        }

        @Override
        public void onClick(View v) {
            listener.onHeaderItemClicked((News) itemView.getTag());
        }
    }


}

