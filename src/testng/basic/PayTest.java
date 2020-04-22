package testng.basic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayTest {
    @Test
    public void paySuccess() {
        System.out.println("支付成功测试1111");
    }

    @Test(enabled = false)
    public void paySuccess2() {
        System.out.println("支付成功测试2222");
    }
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("PayTest中的BeforeTest");
//	}

}
