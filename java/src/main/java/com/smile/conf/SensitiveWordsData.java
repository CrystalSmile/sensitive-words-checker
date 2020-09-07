package com.smile.conf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class SensitiveWordsData {

    private TreeMap<Character, TreeMap> words = null;

    boolean init(String path){
        BufferedReader bufferedReader = null;
        try {
            TreeMap<Character, TreeMap> tmpWords = new TreeMap<>();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                parseAndPut(line.trim(), tmpWords);
            }
            words = tmpWords;
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

    private void parseAndPut(String content, TreeMap<Character, TreeMap> tmpWords){
        if(content == null || content.isEmpty())
            return;

        TreeMap<Character, TreeMap> genNewNode;
        TreeMap<Character, TreeMap> curNode = tmpWords;
        for(int i = 0; i < content.length(); ++i){
            genNewNode = curNode.get(content.charAt(i));
            if(genNewNode == null){
                genNewNode = new TreeMap<>();
                curNode.put(content.charAt(i), genNewNode);
            }
            curNode = genNewNode;
        }
        curNode.put('\n', new TreeMap());
    }

    public TreeMap<Character, TreeMap> getWords(){
        return words;
    }

}
