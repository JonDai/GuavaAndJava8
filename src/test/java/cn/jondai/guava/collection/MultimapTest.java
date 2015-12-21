package cn.jondai.guava.collection;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.TreeMultimap;

/**
 * Test class for Multimap简化了一些复杂的数据结构的操作 
 * eg:Map<String,List<String,String>> imap = new HashMap<String,ArrayList<String,String>>();
 * if Multmap<String,String> multmao = HashSetMultmap.create();
 */

public class MultimapTest {

    @Test
    public void shouldTestHowMultimapWorks() throws Exception {
    	
        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // when
        multimap.put("Poland", "Warsaw");
        multimap.put("Poland", "Cracow");
        multimap.put("Poland", "Plock");
        multimap.put("Poland", "Gdansk");

        multimap.put("Germany", "Berlin");
        multimap.put("Germany", "Bremen");
        multimap.put("Germany", "Dortmund");
        multimap.put("Germany", "Koln");

        multimap.put("Portugal", "Lisbone");
        multimap.put("Portugal", "Porto");
        multimap.put("Portugal", "Leira");
        multimap.put("Portugal", "Funchal");
        multimap.put("Portugal", "Funchal");//重复


        // then
        assertTrue(multimap.get("Poland").size() == 4);
        assertTrue(multimap.get("Portugal").size() == 5);
        assertThat((multimap.get("Poland")), contains("Warsaw","Cracow","Plock","Gdansk"));
        assertTrue(multimap.keys().size() == 13);
    }

    /**
     * asMap 之后重复的键值对会被覆盖一个
     */
    @Test
    public void shouldAsMap(){
    	SetMultimap<String,String> multsetMap = TreeMultimap.create();
    	multsetMap.put("Portugal", "Lisbone");
    	multsetMap.put("Portugal", "Porto");
    	multsetMap.put("Portugal", "Leira");
    	multsetMap.put("Portugal", "Funchal");
    	multsetMap.put("Portugal", "Funchal");//重复
    	Map<String, Collection<String>> ilist = multsetMap.asMap();
    	assertTrue(ilist.get("Portugal").size() == 4);
    }
}