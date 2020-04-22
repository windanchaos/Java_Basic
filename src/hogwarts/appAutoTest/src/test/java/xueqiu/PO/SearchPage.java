package xueqiu.PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends AppBase {
    //初始化的时候就点击
    public SearchPage() {
        driver.findElementById("com.xueqiu.android:id/tv_search").click();
    }

    public SearchPage searchClick(String name) {
        driver.findElementById("com.xueqiu.android:id/search_input_text").sendKeys(name);
        driver.findElementById("com.xueqiu.android:id/name").click();
        return this;
    }

    public SearchPage serchClickStock(String name) {
        searchClick(name).findelement(By.id("com.xueqiu.android:id/stock_layout")).click();
        return this;
    }

    public void back2() {
        driver.findElementById("com.xueqiu.android:id/action_back").click();
    }

    public void back() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
