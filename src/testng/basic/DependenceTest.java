package testng.basic;

import org.testng.annotations.Test;

public class DependenceTest {
    @Test
    public void test1() {
        System.out.println("Test1 执行");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("Test2 执行");
        throw new RuntimeException("Test2失败");
    }

    @Test(dependsOnMethods = {"test1", "test2"}, alwaysRun = true)
    public void test3() {
        System.out.println("Test3 执行");
    }
}
