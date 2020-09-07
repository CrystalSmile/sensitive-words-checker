package com.smile;

public class WordsTest {

    public static void check(String content){
        System.out.println();
        System.out.println("原始文： " + content);
        System.out.println("过滤后： " + SensitiveWordsManager.filter(content) + "  -->res:" + SensitiveWordsManager.hadSensitiveWords(content));
    }

}
