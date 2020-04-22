package testng.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotation {
    //	public static void main(String[] args) {
//		System.out.println("主函数跑起来了");
//	}
    //方法标记未测试一部分
    @Test(timeOut = 300)
    public void testCase1() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("测试用例111，标签@Test");
    }

    @BeforeMethod
    public void testBeforeMethod() {
        System.out.println("#########\n+测试方法之前运行的，标签@BeforeMethod");
    }

    @AfterMethod
    public void testAfterMethod() {
        System.out.println("#########\n 测试方法之后运行的，标签@AfterMethod");
    }

    @Test(timeOut = 300)
    public void testCase2() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("测试用例222，标签@Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("这是在累之前运行的方法，@BeforeClass");
    }

    @AfterClass
    public void aftereClass() {
        System.out.println("这是在类之后运行的方法，@AfterClass");
    }

    @BeforeSuite
    public void beforeSuite() {

    }

    @AfterSuite
    public void afterSuite() {

    }
}
