package com.smile;

import com.smile.conf.CfgLoader;
import com.smile.filter.FilterLoader;

/**
 * 敏感词管理
 */
public class SensitiveWordsHandler
{
    /*
    加载配置
     */
    public static boolean init(String cfgPath){
        return (CfgLoader.getInstance().init(cfgPath) && FilterLoader.getInstance().init());
    }

    /*
    依据配置需要替换字符串，替换敏感词
     */
    public static String filter(String content){

        return content;
    }

    /*
    判断该内容是否包含敏感词
     */
    public static boolean hadSensitiveWords(String content){

        return false;
    }

}
