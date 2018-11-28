package javaCoreOne.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/*
 * 5-13
 */
public class ReflectionTest {

	public static void main(String[] args) {
		String name;
		if(args.length>0) {
			name=args[0];
		}else
		{
			Scanner inScanner=new Scanner(System.in);
			System.out.println("Enter class name(e.g java.util.Date)");
			name=inScanner.nextLine();
		}
		try {
			Class c1=Class.forName(name);
			Class superc1=c1.getSuperclass();
			String modifiers=Modifier.toString(c1.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			System.out.print("class "+name);
			if (superc1!=null && superc1!=Object.class ) {
				System.out.print(" extends "+superc1.getName());
			}
			System.out.print("\n{\n");
			printFields(c1);
			printConstructors(c1);
			printMethods(c1);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//类构造器相关
	public static void printConstructors(Class cl) {
		Constructor[] constructors=cl.getConstructors();
		for(Constructor c:constructors) {
			String name=c.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers+" ");
			System.out.print(name+"(");
			
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++) {
				if(j>0) System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		System.out.println();
	}
	//类方法相关
	public static void printMethods(Class cl) {
		Method[] methods=cl.getMethods();
		for(Method m:methods) {
			Class retType=m.getReturnType();
			String name=m.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(m.getModifiers());
			if (modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(retType.getName()+" "+name+"(");
			Class[] paramTypes=m.getParameterTypes();
			for(int i=0;i<paramTypes.length;i++) {
				if(paramTypes.length>0) System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
		System.out.println();
	}
	
	//类参数有关
	public static void printFields(Class cl) {
		Field[] fields=cl.getDeclaredFields();
		for(Field f:fields) {
			Class type=f.getType();
			String name=f.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(f.getModifiers());
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.println(type.getName()+" "+name+";");
		}
		System.out.println();
	}
	
}
