package com.yuanyang.lession8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yuanyang on 16/8/15.
 */
public class ArticleListFrgment extends Fragment implements AdapterView.OnItemClickListener {


    private ArrayList<String> articleList;

    public static final String EXTRA_LIST_ARTICLE = "_extra_artilce_list";

    private onArticleSelectedListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_article, container, false);
    }

    public void setListener(onArticleSelectedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list_article = (ListView) view.findViewById(R.id.list_artilce);
        articleList = getArguments().getStringArrayList(EXTRA_LIST_ARTICLE);
        list_article.setOnItemClickListener(this);
        list_article.setAdapter(new ArticleListAdapter());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (listener != null) {
            listener.onArticleSelected(articleList.get(i));
        }
    }


    class ArticleListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return articleList == null ? 0 : articleList.size();
        }

        @Override
        public Object getItem(int i) {
            return articleList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_article_lsit, viewGroup, false);
            TextView tv_name_artilce = (TextView) itemView.findViewById(R.id.tv_name_article);
            tv_name_artilce.setText(articleList.get(i));
            return itemView;
        }
    }

    public interface onArticleSelectedListener {
        void onArticleSelected(String articleName);
    }
}
