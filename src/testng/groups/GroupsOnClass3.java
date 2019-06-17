package testng.groups;

import org.testng.annotations.Test;

@Test(groups= {"teacher"})
public class GroupsOnClass3 {
	public void teach1() {
		System.out.println("GroupsOnClass3中的teach1111运行");
	}
	public void teach2() {
		System.out.println("GroupsOnClass3中的teach2222运行");
	}
}
