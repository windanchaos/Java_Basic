package xueqiu.PO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AppBase {
    protected static AndroidDriver driver;
    public static frame.AppBase appBase;

    public AppBase() {
        //保证只有一个实例和driver存在
        if (null == appBase && null == appBase.driver) {
            frame.AppBase.initApp(null);
        }
    }

    public static void init() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("app", "/Users/seveniruby/Downloads/com.xueqiu.android_11.2_174.apk");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appActivity", ".common.MainActivity");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("noReset", "true");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebElement findelement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    public AppBase click(WebElement element) {
        element.click();
        return this;
    }

    /*
    元素判定是否存在，提供给断言使用
     */
    public static boolean elementExist(String xpath) {
        By by = new By.ByXPath(xpath);
        try {
            return driver.findElement(by).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
