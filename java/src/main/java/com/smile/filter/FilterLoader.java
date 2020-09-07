package com.smile.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterLoader {
    private final static FilterLoader instance = new FilterLoader();
    public static FilterLoader getInstance() {
        return instance;
    }
    private FilterLoader() {}

    private List<WordsFilter> chains = new ArrayList<>();

    public void addFilter(WordsFilter filter){
        chains.add(filter);
    }

    public String filter(String content){
        StringBuilder ss = new StringBuilder().append(content);
        for(int i = 0; i < chains.size(); ++i){
            ss = chains.get(0).filter(ss);
        }
        return ss.toString();
    }


}
