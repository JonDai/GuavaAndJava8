package cn.jondai.guava.base;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;
import cn.jondai.guava.UserProfile;

public class ObjectsTest {
    //此处的UserProfile重写的equal、hashCode方法
    UserProfile objectsLesson = new UserProfile("name", "nickname", 20);
    UserProfile objectsLesson2 = new UserProfile("name", "nickname", 20);
    UserProfile nullNicknameObject = new UserProfile("name", null, 20);

    @Test
    public void shouldTestEquals() throws Exception {
    	assertTrue(objectsLesson.equals(objectsLesson2));
    }

    @Test
    public void shouldTestHashcode() throws Exception {
    	assertThat(objectsLesson.hashCode(),equalTo(objectsLesson2.hashCode()));
    }

    @Test
    public void shouldRenderNameAsDisplayableName() throws Exception {
    	assertTrue("name".equals(nullNicknameObject.getDisplayName()));
    }

    @Test
    public void shouldShowHowToStringMethodWorks() throws Exception {
    	assertTrue("UserProfile{name=name, nickname=nickname, 20}".equals(objectsLesson.toString()));
    }
}
