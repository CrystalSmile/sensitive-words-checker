package com.smile;

import com.smile.conf.CfgLoader;
import com.smile.filter.FilterLoader;

/**
 * 敏感词管理
 */
public class SensitiveWordsManager
{
    /*
    加载配置
     */
    public static boolean init(String cfgPath){
        return (CfgLoader.getInstance().init(cfgPath));
    }

    /*
    依据配置需要替换字符串，替换敏感词
     */
    public static String filter(String content){
        return FilterLoader.getInstance().filter(content);
    }

    /*
    判断该内容是否包含敏感词
     */
    public static boolean hadSensitiveWords(String content){
        return (!(content.equals(FilterLoader.getInstance().filter(content))));
    }

}
