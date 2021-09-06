package com.example.spg.views;

import android.content.Intent;

public class Pageritem {
    private String title;
    private Integer picResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPicResId() {
        return picResId;
    }

    public void setPicResId(Integer picResId) {
        this.picResId = picResId;
    }

    public Pageritem(String title, Integer picResId) {
        this.title = title;
        this.picResId = picResId;
    }
}
