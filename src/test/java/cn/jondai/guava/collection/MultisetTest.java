package cn.jondai.guava.collection;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Test class for Multiset 是List和Set之间的一个区域 可以存储相同的对象，并且会计算相同对象存储的个数(count)
 */

public class MultisetTest {


    @Test
    public void shouldAddElementTwoTimes() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        // when
        multiset.add("nothing");
        multiset.add("nothing");

        // then
        assertTrue(multiset.count("nothing") == 2);
        assertTrue(multiset.count("something") == 0);
    }

    @Test
    public void shouldUserCustomAddRemoveAndSetCount() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        // when add(element,count)  添加对应个数的元素
        multiset.add("ball");
        multiset.add("ball", 10);

        // then
        assertTrue(multiset.count("ball") == 11);

        // when
        multiset.remove("ball", 5);

        // then
        assertTrue(multiset.count("ball") == 6);

        
        // when
        multiset.setCount("ball", 2);
      
        // then
        assertTrue(multiset.count("ball") == 2);
    }


    @Test
    public void shouldRetainOnlySelectedKeys() throws Exception {

        // given
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("ball");
        multiset.add("ball");
        multiset.add("cow");
        multiset.setCount("twelve", 12);

        // when 保留出现在给定集合参数的所有的元素，移除不属于集合内的所有元素
        multiset.retainAll(Arrays.asList("ball", "horse"));

        assertTrue(multiset.count("ball") == 2);
        assertTrue(multiset.count("cow") == 0);
    }

}
