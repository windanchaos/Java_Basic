import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

//测试用例顺序指定，原则用例之间独立互相不依赖。
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4DemoChild {
    @BeforeClass
    public static void before() {
        System.out.println("类执行前执行before");
    }

    @AfterClass
    public static void after() {
        System.out.println("类最后执行after");
    }

    @Before
    public void beforeMethod() {
        System.out.println("beforMethod");
    }

    @Test
    public void testDemo3Child() {
        System.out.println("testDemo3");
        assertTrue(false);
    }

    @Test
    public void testDemo1Child() {
        System.out.println("testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2Child() {
        System.out.println("testDemo2");
        assertTrue(false);
    }

}
