package frame;

import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.HashMap;

public class CommonTools {
    //通用组件
    //右上角button
    public static By title_right_btn = By.id("com.maike51.xke:id/tv_title_right_btn");
    //左上角返回button
    public static By title_back = By.id("com.maike51.xke:id/iv_title_back");

    public static void clickRightBtn() {
        AppBase.click(title_right_btn);
    }

    public static void clickBack() {
        AppBase.click(title_back);
    }

    public static By TextViewXpathTextGenerator(String text) {
        StringBuilder consumerString = new StringBuilder("//android.widget.TextView[contains(@text,'')]");
        consumerString.insert(consumerString.length() - 3, text);
        return By.xpath(consumerString.toString());
    }

    public static By TextViewXpathTextGeneratorStrict(String text) {
        StringBuilder consumerString = new StringBuilder("//android.widget.TextView[@text='']");
        consumerString.insert(consumerString.length() - 2, text);
        return By.xpath(consumerString.toString());
    }

    //反射方式设置PO中定位元素的值
    public static void setByFields(Object instance, HashMap<String, By> elements) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getType() == By.class) {
                fields[i].setAccessible(true);
                try {
                    fields[i].set(instance, elements.get(fields[i].getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
