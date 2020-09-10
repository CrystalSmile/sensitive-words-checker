package com.smile.filter;

import com.smile.conf.IgnoreCharData;
import com.smile.conf.SensitiveWordsData;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SensitiveWordsFilter implements WordsFilter {

    SensitiveWordsData sensitiveWordsData;
    IgnoreCharData globalIgnoreData;

    public SensitiveWordsFilter(SensitiveWordsData sensitiveWordsData, IgnoreCharData ignoreCharData) {
        this.sensitiveWordsData = sensitiveWordsData;
        this.globalIgnoreData = ignoreCharData;
    }

    @Override
    public StringBuilder filter(StringBuilder content) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < content.length(); ) {
            i = filterOneByOne(content, res, i);
        }
        return res;
    }

    int filterOneByOne(StringBuilder words, StringBuilder res, int startIdx) {
        TreeMap<Character, TreeMap> curCheckNode = sensitiveWordsData.getWords();

        int lastEndIdx = startIdx;
        int lastChangeIdx = -1;
        for (int i = startIdx; i < words.length(); ++i) {
            char curCheck = words.charAt(i);

            TreeMap<Character, TreeMap> nextGetNode = curCheckNode.get(words.charAt(i));
            if (nextGetNode == null) {
                if (curCheckNode.containsKey('\n')) {
                    lastChangeIdx = i;
                }
                break;
            } else if (nextGetNode.containsKey('\n')) {
                if (nextGetNode.size() == 1) {
                    lastChangeIdx = i + 1;
                    break;
                }else{
                    for (int j = lastEndIdx; j <= i; j++) {
                        res.append("*");
                    }
                    lastEndIdx = i + 1;
                }
            }
            curCheckNode = nextGetNode;
        }

        if(lastChangeIdx > 0){
            for (int j = lastEndIdx; j < lastChangeIdx; j++) {
                res.append("*");
            }
            return lastChangeIdx;
        }else if (lastEndIdx == startIdx) {
            res.append(words.charAt(startIdx));
            return startIdx + 1;
        } else {
            return lastEndIdx;
        }
    }


}
