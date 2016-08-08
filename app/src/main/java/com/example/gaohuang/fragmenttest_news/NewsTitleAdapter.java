package com.example.gaohuang.fragmenttest_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohuang on 2016/8/8.
 */
public class NewsTitleAdapter extends ArrayAdapter<News> {

    private int resourceId;

    public NewsTitleAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view;

        if(null == convertView){
            view = LayoutInflater.from(getContext()).inflate(this.resourceId, null);
        }else{
            view = convertView;
        }

        News news = getItem(position);
        TextView textView = (TextView)view.findViewById(R.id.news);
        textView.setText(news.getTitle());

        return view;
    }
}
