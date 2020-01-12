//package main.java;
//
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class XueqiuDemo {
//
//    private AndroidDriver driver;
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "a6ac60b");
//        desiredCapabilities.setCapability("udid", "a6ac60b");
//        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
//        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
//
//        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void sampleTest() {
//        try {
//            Thread.sleep(5*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        MobileElement element1=(MobileElement) driver.findElementByXPath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[2]");
//        element1.click();
//        driver.findElementByXPath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[3]").click();
//        (new TouchAction(driver))
//                .press(635,1499)
//      .moveTo(650, 546)
//      .release().perform();
//        driver.findElementByXPath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[4]").click();
//        (new TouchAction(driver))
//                .press(683,1544)
//      .moveTo(717,674).release().perform();
//        driver.findElementByXPath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[1]").click();
//        driver.findElementById("com.xueqiu.android:id/tv_search").click();
//        MobileElement el4 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
//        el4.sendKeys("招商银行");
//        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
//        el5.click();
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}
//
//
