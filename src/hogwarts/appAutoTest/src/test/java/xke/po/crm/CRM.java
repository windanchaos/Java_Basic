package xke.po.crm;

import org.openqa.selenium.By;
import xke.po.frame.CommonTools;
import xke.po.frame.AppBase;

import java.util.HashMap;

//客户管理Page,crm的总入口
public class CRM extends AppBase {
    private By collectXpath;
    private By tagXpath;

    //显示构造，否则会调用父类的构造方法
    public CRM() {
        super(null);
        HashMap<String, By> elements = getElementsByConfig();
        //反射方式设置实例中的定位元素的值
        CommonTools.setByFields(this, elements);
    }

    //点击客户认领
    public ConsumerClaim clickCollect() {
        click(collectXpath);
        return new ConsumerClaim(true);
    }

    //点击客户标签
    public ConsumerTag clickTag() {
        click(tagXpath);
        return new ConsumerTag();
    }

    //点击单个客户
    public CRM clickConsumer(String name) {
        scrollFindElement(By.id("com.maike51.xke:id/tvCity"), CommonTools.TextViewXpathTextGenerator(name));
        click(CommonTools.TextViewXpathTextGenerator(name));
        return this;
    }
}

