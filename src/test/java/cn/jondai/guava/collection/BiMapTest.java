package cn.jondai.guava.collection;

import org.junit.Test;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
/**
 * BiMap 是一个双向绑定的Map，在普通的Map中我们只能进行key-->value的映射。 而BiMap可以达到value-->key映射的效果
 */
public class BiMapTest {

    @Test
    public void shouldInverseBiMap() throws Exception {
        BiMap<Integer, String> bimap = HashBiMap.create();
        // when
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        //BiMap.inverse() ：是将Map中的key与value交换
        BiMap<String, Integer> inversedBiMap = bimap.inverse();
        // then
        assertThat(1,equalTo(inversedBiMap.get("one")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToPutExistingValue() throws Exception {
        BiMap<Integer, String> bimap = HashBiMap.create();
        // when  BiMap中的value有唯一性，如果插入重复的值则抛出异常
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        bimap.put(10, "one");
        fail("Should throw IllegalArgumentException");
    }

    @Test
    public void shouldAllowToPutExistingValueWithForcePut() throws Exception {
        BiMap<Integer, String> bimap = HashBiMap.create();
        // when 如果需要插入已有的重复的值，可以使用forcePut(),但是已有的键值对会被覆盖
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        bimap.forcePut(10, "one");

        assertThat("one",equalTo(bimap.get(10)));
        assertTrue(bimap.get(1) == null);

    }
}
