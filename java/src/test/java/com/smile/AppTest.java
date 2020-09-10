package com.smile;

import static org.junit.Assert.assertTrue;

import com.smile.filter.FilterLoader;
import org.junit.Test;

/**
 * Unit test for simple SensitiveWordsManager.
 */
public class AppTest 
{
    @Test
    public void testBase(){
        SensitiveWordsManager.init("E:\\GitSource\\sensitive-words-checker\\data");

        WordsTest.check("当天下午，中共中央、国务院、中央军委在人民大会堂举行座谈会，纪念中国人民抗日战争暨世界反法西斯战争胜利75周年，习近平总书记发表重要讲话。");
        WordsTest.check("你个狗娘养的坏蛋");
        WordsTest.check("会议上习#近#平总书记发表重要讲话。");
    }


}
