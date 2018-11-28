package javaCoreOne.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,5,6};
		int[] b=(int[])goodcopy(a, 10);
		System.out.println(Arrays.toString(b));
		String[] s= {"1","a2","dad5a","da632"};
		String[] s2=(String[])goodcopy(s, 10);
		System.out.println(Arrays.toString(s2));		
		

	}

	public static Object goodcopy(Object a, int newLength) {
		Class cl = a.getClass();
		if (!cl.isArray())
			return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
}
