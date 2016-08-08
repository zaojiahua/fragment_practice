package com.example.gaohuang.fragmenttest_news;

/**
 * Created by gaohuang on 2016/8/8.
 */
public class News {
    public String title;
    public String content;

    public News(){

    }

    public News(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

}
