package com.yuanyang.lession8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuanyang on 16/8/15.
 */
public class ArticleDetailFragment extends Fragment {

    public static final java.lang.String EXTRA_DETAIL_ARTILCE = "_extra_article";
    private TextView tv_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_article, container, false);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(getArguments().getString(EXTRA_DETAIL_ARTILCE));
        tv_content.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setData(String text) {
        if (tv_content != null) {
            tv_content.setText(text);
        }
    }
}
