package com.example.gaohuang.fragmenttest_news;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class NewsContentActivity extends Activity {

    public static void actionStart(Context context, String title, String content){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content_activity);

        ContentFragment contentFragment = (ContentFragment)getFragmentManager().findFragmentById(R.id.content_fragment);
        contentFragment.refresh(getIntent().getStringExtra("title"), getIntent().getStringExtra("content"));
    }
}
