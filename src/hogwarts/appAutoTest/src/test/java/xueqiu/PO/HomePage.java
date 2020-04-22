package xueqiu.PO;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends AppBase {
    /*
    热门
     */
    public HomePage getPopular() {
        driver.findElementByXPath("//*[@resource-id='com.xueqiu.android:id/title_text' and @text='热门']").click();
        return this;
    }

    /*
     推荐
    */
    public HomePage getRecommend() {
        driver.findElementByXPath("//*[@resource-id='com.xueqiu.android:id/title_text' and @text='推荐']").click();
        return this;
    }

    /*
    关注
     */
    public HomePage getFocus() {
        driver.findElementByXPath("//*[@resource-id='com.xueqiu.android:id/title_text' and @text='关注']").click();
        return this;
    }

}
