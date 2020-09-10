package com.smile.conf;

import com.smile.filter.FilterLoader;
import com.smile.filter.SensitiveWordsFilter;

import java.io.File;

public class CfgLoader {
    private final static CfgLoader instance = new CfgLoader();
    public static CfgLoader getInstance() {
        return instance;
    }
    private CfgLoader() {}

    public boolean init(String dataPath){
        File dataFile = new File(dataPath);
        if(!dataFile.exists()){
            System.out.println("CfgLoader:init words file not found!");
            return false;
        }

        IgnoreCharData ignoreCharData = new IgnoreCharData();
        ignoreCharData.init(dataFile.getAbsolutePath() + File.separator + "global_ignore_char.txt");

        SensitiveWordsData tmpSensitiveWordsData = new SensitiveWordsData();
        if(tmpSensitiveWordsData.init(dataFile.getAbsolutePath() + File.separator + "sensitivewords.txt")){
            FilterLoader.getInstance().addFilter(new SensitiveWordsFilter(tmpSensitiveWordsData, ignoreCharData));

        }else{
            System.out.println("CfgLoader:init init base word fail");
            return false;
        }

        return  true;
    }

}
