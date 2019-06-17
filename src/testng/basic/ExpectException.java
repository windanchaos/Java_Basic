package testng.basic;

import org.testng.annotations.Test;

public class ExpectException {
	@Test(expectedExceptions=RuntimeException.class)
	public void runTimeExceptionFailed() {
		System.out.println("这个方法测试将失败，因为没有抛出执行时错误");
	}
	@Test(expectedExceptions=RuntimeException.class)
	public void runTimeExceptionSuccess() {
		System.out.println("这个方法测试将成功，因为抛出执行时错误");
		throw new RuntimeException("程序抛出异常");
	}
	
}
