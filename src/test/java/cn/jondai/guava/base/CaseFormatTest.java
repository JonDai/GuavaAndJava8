package cn.jondai.guava.base;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import com.google.common.base.CaseFormat;

/**
 * CaseFormat features
 */
public class CaseFormatTest {

    @Test
    /**
     * UPPER_CAMEL:驼峰规范，首字母大写
     * UPPER_UNDERSCORE:匹配大写字母，前置增加'_'
     */
    public void shouldConvertToUpperUnderscore() throws Exception {
        assertThat("HELLO_WORLD_A",equalTo(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,"HelloWorldA")));
    }


    @Test
    public void shouldConvertToLowerCamel() throws Exception {
        assertThat("helloWorldA",equalTo(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "HELLO_WORLD_A")));
    }

    @Test
    public void shouldConvertToLowerHyphen() throws Exception {
    	assertThat("hello-world",equalTo(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "helloWorld")));
    }
}
