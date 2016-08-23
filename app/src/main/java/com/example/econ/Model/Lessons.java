package com.example.econ.Model;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jerome on 8/15/2016.
 */
public class Lessons {

    public String title;
    public int description;
    public int background;
    public Intent activity;

    public Lessons(String title, int description, int background, Intent activity){
        this.title = title;
        this.description = description;
        this.background = background;
        this.activity = activity;
    }

}

