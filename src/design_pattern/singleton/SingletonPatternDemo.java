package design_pattern.singleton;

import java.security.SignedObject;

public class SingletonPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleObject singleObject=SingleObject.getInstance();
		System.out.println(singleObject.getCallNumber());
		System.out.println(singleObject.getCallNumber());
		System.out.println(singleObject.getCallNumber());
		System.out.println(singleObject.getCallNumber());
	}

}
