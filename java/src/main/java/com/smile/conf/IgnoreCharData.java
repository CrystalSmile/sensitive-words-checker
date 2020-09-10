package com.smile.conf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 加载敏感词检查中可忽略特殊字符 :
 *     --》当匹配过程中遇到特殊字符略过，并继续匹配
 *     --》如敏感词：习近平，特殊字符：# 这时：如出现：习#近#平总书记，可过滤掉
 * 补充utf-8编码范围外的
 */
public class IgnoreCharData {

    private Set<Character> globalIgnore = new HashSet<>();

    boolean init(String path){
        BufferedReader bufferedReader = null;
        try {
            Set<Character> tempignorechars = new HashSet<>();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                for(Character aCharacter : line.trim().toCharArray()){
                    if(Character.isSpaceChar(aCharacter)){
                        continue;
                    }
                    tempignorechars.add(aCharacter);
                }
            }
            globalIgnore = tempignorechars;
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public boolean isIgnoreChar(char check){
        return globalIgnore.contains(check);
    }

}
