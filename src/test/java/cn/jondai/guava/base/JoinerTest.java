package cn.jondai.guava.base;

import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.common.base.Joiner;

/**
 * Test class to show some features of Joiners
 */
public class JoinerTest {
    public static List<String> languages = Arrays.asList("Java", "Haskell", "Scala", "Brainfuck");

    @Test
    public void shouldJoinWithCommas() throws Exception {
    	//可以将继承了Iterable的对象连接成一个字符串
    	assertThat("Java,Haskell,Scala,Brainfuck",equalTo((Joiner.on(",").join(languages))));
    }

    public static List<String> countriesWithNullValue = Arrays
            .asList("Poland", "Brasil", "Ukraine", null, "England", "Croatia");

    //当集合内包涵了null是，会快速失败
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() throws Exception {
        assertThat("Poland,Brasil,Ukraine,null,England,Croatia",equalTo(Joiner.on(",").join(countriesWithNullValue)));
    }

    @Test
    public void shouldJoinWithCommasAndOmitNulls() throws Exception {
    	//遇到null时跳过
    	assertThat("Poland,Brasil,Ukraine,England,Croatia",equalTo(Joiner.on(",").skipNulls().join(countriesWithNullValue)));
    }

    @Test
    public void shouldJoinWithCommasAndReplaceNullsWithWordNothing() throws Exception {
    	//当遇遇到null是，useForNullti代替
    	assertThat("Poland,Brasil,Ukraine,NONE,England,Croatia", equalTo(Joiner.on(",").useForNull("NONE").join(countriesWithNullValue)));
    }

    public static Map<Integer, String> numbersWords = new HashMap<Integer, String>();

    static {
        numbersWords.put(1, "one");
        numbersWords.put(2, "two");
        numbersWords.put(3, null);
        numbersWords.put(4, "four");
    }

    @Test
    public void shouldJoinMap() throws Exception {
    	//在map中除了on方法只对一对key-value有效，而key与value之间可以使用withKeyValueSeparator
        assertThat("1 -> one | 2 -> two | 3 -> Unknown | 4 -> four",
        		equalTo(Joiner.on(" | ").withKeyValueSeparator(" -> ").useForNull("Unknown").join(numbersWords)));
    }

}