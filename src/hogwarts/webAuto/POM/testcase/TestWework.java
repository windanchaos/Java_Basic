package hogwarts.webAuto.POM.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWework {
    public static String url="https://work.weixin.qq.com/";
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        driver.get(url);
        driver.manage().addCookie(new Cookie());
    }
    @After
    public void tearDown(){

    }

    @Test
    public void login(){

    }

}
