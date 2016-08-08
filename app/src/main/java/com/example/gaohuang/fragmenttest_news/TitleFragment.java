package com.example.gaohuang.fragmenttest_news;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment implements AdapterView.OnItemClickListener{

    private List<News> newsList = new ArrayList<News>();
    private View view;
    private boolean twoPanel = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.news_title_fragment, container, false);

        addNews();
        NewsTitleAdapter newsAdapter = new NewsTitleAdapter(getActivity(), R.layout.news_title_item, newsList);
        ListView listView = (ListView)view.findViewById(R.id.listview);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(null == getActivity().findViewById(R.id.content_fragment)){
            twoPanel = false;
        }
        else{
            twoPanel = true;
        }
    }

    private void addNews(){
        for(int i = 0; i < 20; i++){
            News news = new News();
            news.setTitle("Succeed in College as a Learning Disabled Student");
            news.setContent("setContent(\"College freshmen will soon learn to live with a\n" +
                    "roommate, adjust to a new social scene and survive less-than-stellar\n" +
                    "dining hall food. Students with learning disabilities will face these\n" +
                    "transitions while also grappling with a few more hurdles.");
            newsList.add(news);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);

        if(twoPanel){
            ContentFragment contentFragment = (ContentFragment)getFragmentManager().findFragmentById(R.id.content_fragment);
            contentFragment.refresh(news.getTitle(), news.getContent());
        }else{
            NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
        }
    }
}
