package testng.basic;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SuiteConfig {
    @BeforeTest
    public void beforeTest() {
        System.out.println("SuiteConfig中的BeforeTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("套件之前运行");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("套件之后运行");
    }

    @Test
    public void configTest() {
        System.out.println("SuiteConfig中的测试一");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("SuiteConfig中的beforeMethod");
    }

}

