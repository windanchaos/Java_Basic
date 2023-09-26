package xke.testCase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import frame.CommonTools;
import xke.po.crm.CRM;
import xke.po.crm.ConsumerInfo;

import java.util.HashMap;

//这个类用标准启动方式测试
public class ConsumerInfoTest {
    public static CRM crm;
    static ConsumerInfo consumerInfo;

    @BeforeAll
    public static void setUp() {
        crm = new CRM();
        crm.toCRM();
        consumerInfo = new ConsumerInfo();
    }

    @Test
    @Order(1)
    public void testExplore() {
        crm.clickConsumer("一只锤子");
        consumerInfo.orderList();
        consumerInfo.frindcircle().browser(5);
        //浏览后返回
        CommonTools.clickBack();
    }

    @Test
    @Order(10)
    public void testEdit() {

        HashMap<String, String[]> tags = new HashMap<>();
        String[] addr = {"成都", "绵阳"};
        tags.put("地址", addr);
        String[] education = {"硕士"};
        tags.put("用户学历", education);
        String[] height = {"160-170cm"};
        tags.put("身高", height);

        String phone = "1888888888";
        String comment = "一只锤子";
        crm.clickConsumer("一只锤子");
        consumerInfo.editInfo(tags, phone, comment);
    }


}
