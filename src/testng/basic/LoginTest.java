package testng.basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void logSuccess() {
		System.out.println("淘宝登录成功111");
	}
	@Test
	public void logSuccess2() {
		System.out.println("淘宝登录成功222");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("LoginTest中的BeforeTest");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("LoginTest中的BeforeMethod");
	}
	 @BeforeClass
	 public void setUp() {
	   // code that will be invoked when this test is instantiated
	 }
	 
	 @Test(groups = { "fast","slow" })
	 public void aFastTest() {
	   System.out.println("Fast test");
	 }
	 
	 @Test(groups = { "slow" })
	 public void aSlowTest() {
	    System.out.println("Slow test");
	 }

}
