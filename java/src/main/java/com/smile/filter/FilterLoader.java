package com.smile.filter;

import com.smile.conf.CfgLoader;

import java.io.File;

public class FilterLoader {
    private final static FilterLoader instance = new FilterLoader();
    public static FilterLoader getInstance() {
        return instance;
    }
    private FilterLoader() {}

    public boolean init(){

        return  true;
    }

}
