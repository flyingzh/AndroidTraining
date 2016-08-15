package com.yuanyang.lession8;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 与其他的Fragment交互
 */
public class MainActivity extends FragmentActivity implements ArticleListFrgment.onArticleSelectedListener {

    private HashMap<String, String> articles = new HashMap<>();

    private ArrayList<String> articleNames = new ArrayList<>();
    private ArticleListFrgment articleListFrgment;
    private ArticleDetailFragment articleDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        articleListFrgment = new ArticleListFrgment();
        articleListFrgment.setListener(this);
        articleDetailFragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ArticleListFrgment.EXTRA_LIST_ARTICLE, articleNames);
        getSupportFragmentManager().beginTransaction().add(R.id.contailer_list_article, articleListFrgment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contailer_detail_article, articleDetailFragment).commit();
        articleListFrgment.setArguments(args);
        Bundle content = new Bundle();
        content.putString(ArticleDetailFragment.EXTRA_DETAIL_ARTILCE, articles.get(articleNames.get(0)));
        articleDetailFragment.setArguments(content);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            articleNames.add("盗墓笔记" + i);
            articles.put("盗墓笔记" + i, i + "《盜墓筆記》，是一部中國大陸的網絡小說，曾于起点中文网连载。共出版实体书九本，《盗墓笔记捌：大结局（上、下）》于2011年12月19日上市，是《盗墓笔记》系列的完结篇。《盗墓笔记》系列是南派三叔的代表作，主要內容是盜墓解謎，作者南派三叔的本名为徐磊。\n" +
                    "\n" +
                    "小說單行本在中國大陸前6卷由中国友谊出版公司出版；第七卷初版由时代文艺出版社出版，再版由上海文化出版社出版；周邊書目由万卷出版公司、知音书局、长江出版社等出版社出版。大陸地區版本因審查制度對作者原文有所刪改。在台灣地區由普天出版社出版正體中文版。\n" +
                    "\n" +
                    "2012年在小说连载杂志《超好看》连载《藏海花》。《藏海花》是《盗墓笔记》中人物張起靈的外傳，敘述張起靈遇到吳邪等人之前的故事。之后又推出《盗墓笔记少年篇：沙海》，实体书已出版4本。");
        }
    }


    @Override
    public void onArticleSelected(String articleName) {
        articleDetailFragment.setData(articles.get(articleName));
    }
}
