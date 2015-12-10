package cn.jondai.guava.base;

import java.util.Iterator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * Class to show some features of Splitter class
 */
public class SplitterTest {

    public static String textWithDigitsAsADelimeter = "Java1Scala2Haskell3444Brainfuck452Kotlin";
    public static String textWithDigitsFrom3To5AsADelimeter = "Java3Scala4Haskell0Brainfuck5Kotlin";
    public static String textWithFiveCharactersWords = "HorseHouseGroupDemosScrum";
    public static String textWithSemicolonAsADelimeterWithEmptyElementsAndSpaces = "Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin";


    @Test
    public void shouldSplitOnSemicolons() throws Exception {
        // when Splitter.split()方法返回一个Iterable
        Iterable<String> iterable = Splitter.on(";").split("Java;Scala;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(5,equalTo(splittedList.size()));
        assertThat("Brainfuck",equalTo(splittedList.get(3)));
    }

    private List<String> convertToList(Iterator<String> iterator) {
    	//Lists.newArrayList()支持范型
        List<String> list = Lists.newArrayList( );

        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @Test
    public void shouldSplitOnRegExp() throws Exception {
        // when onPattern支持正则表达式"\\d+" \\--> \, \d -->数字 '+'-->重复一次或者多次 
    	// '\\d+':匹配一个或者多个数字
        Iterable<String> iterable = Splitter.onPattern("\\d+").split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(5,equalTo(splittedList.size()));
        assertThat("Haskell",equalTo(splittedList.get(2)));
    }

    @Test
    public void shouldSplitUsingCharMatcher() throws Exception {
    	//CharMatcher强大的字符匹配
        // when 匹配的数字在3-5之间，包含
        Iterable<String> iterable = Splitter
                .on(CharMatcher.inRange('3', '5')).split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(4,equalTo(splittedList.size()));
        assertThat("Haskell0Brainfuck",equalTo(splittedList.get(2)));

    }

    @Test
    public void shouldSplitAndOmitEmptyElementsAndWhitespaces() throws Exception {
        // when 去掉两端的空格，并忽略空字符串
        Iterable<String> iterable = Splitter.on(";").omitEmptyStrings()
                .trimResults().split("Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(5,equalTo(splittedList.size()));
        assertThat("Scala",equalTo(splittedList.get(1)));

    }

    @Test
    public void shouldSplitForEqualLength() throws Exception {
        // when 每组固定长度 fixedLength
        Iterable<String> iterable = Splitter.fixedLength(5).split("HorseHouseGroupDemosScrum");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(5,equalTo(splittedList.size()));
        assertThat("Scrum",equalTo(splittedList.get(4)));
    }
}
