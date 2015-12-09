package cn.jondai.guava.base;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * Class to show features of Strings class
 */
public class StringsTest {

    @Test
    public void shouldReturnTrueOnNullString() throws Exception {
        assertTrue(Strings.isNullOrEmpty(null));
    }

    @Test
    public void shouldConvertNullToEmpty() throws Exception {
    	assertThat("",equalTo(Strings.nullToEmpty(null)));
    }

    @Test
    public void shouldConvertEmptyToNull() throws Exception {
    	assertThat(null,equalTo(Strings.emptyToNull("")));
    }

    @Test
    /**
     * padEnd在原字符末尾添加字符。如果不足minLength则在原字符串上补充字符，直到有minLength个字符。
     */
    public void shouldPadEnd() throws Exception {
    	assertThat("Nothing***",equalTo(Strings.padEnd("Nothing", 10, '*')));
    }

    @Test
    public void shouldPadStart() throws Exception {
    	assertThat("***Nothing",equalTo(Strings.padStart("Nothing", 10, '*')));
    }

    @Test
    public void shouldRepeatGivenString() throws Exception {
    	assertThat("Hello Hello Hello ",equalTo(Strings.repeat("Hello ", 3)));
    }
}
