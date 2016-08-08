package com.example.gaohuang.fragmenttest_news;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gaohuang on 2016/8/8.
 */
public class ContentFragment extends Fragment {
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.news_content_fragment, container, false);

        return view;
    }

    public void refresh(String title, String content){
        view.findViewById(R.id.visible_layout).setVisibility(View.VISIBLE);

        TextView titleView = (TextView)view.findViewById(R.id.title);
        TextView contentView = (TextView)view.findViewById(R.id.content);

        titleView.setText(title);
        contentView.setText(content);
    }
}
