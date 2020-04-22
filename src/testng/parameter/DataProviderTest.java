package testng.parameter;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider = "data1")
    public void testDataProvider(String name, int age) {
        System.out.println("name = " + name + "; age = " + age);
        System.out.println("Current thread ID: " + Thread.currentThread().getId());

    }

    @DataProvider(name = "data1")
    public Object[][] providerData() {
        Object[][] objects = new Object[][]{{"zhangsan", 10}, {"lisi", 20}, {"wangwu", 30}};
        return objects;
    }

    @Test(dataProvider = "methodData")
    public void testDataProviderFromMethod1(String name, int age) {
        System.out.println("testDataProviderFromMethod111 ### name = " + name + "; age = " + age);
        System.out.println("Current thread ID: " + Thread.currentThread().getId());
    }

    @Test(dataProvider = "methodData")
    public void testDataProviderFromMethod2(String name, int age) {
        System.out.println("testDataProviderFromMethod222 ### name = " + name + "; age = " + age);
        System.out.println("Current thread ID: " + Thread.currentThread().getId());

    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataProvider(Method method) {
        Object[][] objects = null;
        if (method.getName().equals("testDataProviderFromMethod1")) {
            objects = new Object[][]{{"张三", 15}, {"李四", 25}, {"洪七", 17}};
        } else if (method.getName().equals("testDataProviderFromMethod2")) {
            objects = new Object[][]{{"王二麻子", 16}, {"李大", 35}, {"小七", 77}};
        }
        return objects;
    }
}
