package com.smile.conf;

import java.io.File;

public class CfgLoader {
    private final static CfgLoader instance = new CfgLoader();
    public static CfgLoader getInstance() {
        return instance;
    }
    private CfgLoader() {}

    SensitiveWordsData sensitiveWordsData = null;
    PinyinData pinyinData = null;

    public boolean init(String dataPath){
        File dataFile = new File(dataPath);
        if(!dataFile.exists()){
            System.out.println("CfgLoader:init fail!");
            return false;
        }

        SensitiveWordsData tmpSensitiveWordsData = new SensitiveWordsData();
        if(tmpSensitiveWordsData.init(dataFile.getAbsolutePath() + File.separator + "sensitivewords.txt"))
            sensitiveWordsData = tmpSensitiveWordsData;




        return  true;
    }

}
