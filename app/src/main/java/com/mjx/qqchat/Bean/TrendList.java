package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/7.
 */

public class TrendList {

    private int image;
    private String title;
    private String content;
    private String url;

    public TrendList(String url,int image, String title, String content) {
        this.url = url;
        this.image = image;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
