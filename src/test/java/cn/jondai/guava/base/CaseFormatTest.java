package cn.jondai.guava.base;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import com.google.common.base.CaseFormat;

/**
 * CaseFormat用来转换各种不同的编程语言间的变量名命名格式, 主要用到的方法只有一个 CaseFormat.to(CaseFormat from, String s)
 * 
 * LOWER_CAMEL:Java变量的命名规则，如“lowerCamel”
 * LOWER_HYPHEN:连字符连接变量的命名规则，如“lower-hyphen”。
 * LOWER_UNDERSCORE:C ++变量命名规则，如“lower_undersc
 * UPPER_CAMEL:Java和C++类的命名规则，如“UpperCamel”。
 * UPPER_UNDERSCORE:Java和C++常量的命名规则，如“UPPER_UNDERSCORE”。
 */
public class CaseFormatTest {

    @Test
 
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
