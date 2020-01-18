package javaCoreOne.reflection;

import com.sun.nio.zipfs.ZipFileStore;
import org.apache.tools.ant.taskdefs.Classloader;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
		ConcurrentHashMap <String,Object> map = new ConcurrentHashMap <String,Object>();
		System.out.println(map.put("haha", 1));
		System.out.println(map.put("haha", 2));
		System.out.println(map.get("haha"));
		//通过反射获取Class对象
		Class a = Class.forName("javaCoreOne.reflection.Buyer");
		System.out.println(a);
		Class b = Class.forName("javaCoreOne.reflection.Buyer");
		Class c = Class.forName("javaCoreOne.reflection.Buyer");
		//一个雷被加载后，类的结构都被封装到Class的对象中
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(a.getSuperclass());
		System.out.println(a.toGenericString());
		System.out.println(a.getDeclaredClasses().length);
		//所有类的Class
		Class c1=Object.class;
		Class c2=Integer.class;
		Class c3=String[].class;
		Class c4=int[].class;
		Class c5=int[][].class;
		Class c6=Override.class;
		Class c7=Runnable.class;
		Class c8= ElementType.class;
		Class c9=void.class;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
		System.out.println(c9);
		//元素类型和维度相同的数组的类类型相同
		int[] l1 = new int[10];
		int[] l2 = new int[20];
		System.out.println(l1.getClass());
		System.out.println(l2.getClass());
		System.out.println("app用户自定义类加载器"+ClassLoader.getSystemClassLoader());
		System.out.println("扩展类加载器"+ClassLoader.getSystemClassLoader().getParent());
		System.out.println("根加载器"+ClassLoader.getSystemClassLoader().getParent().getParent());
		ClassLoader thisclassLoader = Class.forName("javaCoreOne.reflection.test").getClassLoader();
		System.out.println("自己的类加载器："+thisclassLoader);
		ClassLoader inteClassLoader = Class.forName("java.lang.Integer").getClassLoader();
		System.out.println("javalang包加载器："+inteClassLoader);
		ClassLoader zipCodeClassLoader = Class.forName("com.sun.nio.zipfs.ZipFileStore").getClassLoader();
		System.out.println("ZipFileStor加载器："+zipCodeClassLoader);

		//反射获得类信息
		System.out.println(a.getName());
		System.out.println(a.getSimpleName());
		Method[] methods = a.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getReturnType()+" "+methods[i].getName());
		}
		//declared是所有方法或值域
		Method[] methodsdeclear = a.getDeclaredMethods();
		System.out.println("$###########");
		for (int i = 0; i < methodsdeclear.length; i++) {
			System.out.println(methodsdeclear[i].getReturnType()+" "+methodsdeclear[i].getName());
		}
		System.out.println("$########getDeclaredFields###");
		Field[] fields=a.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType()+" "+fields[i].getName());
		}
		//利用反射新建对象,这里提前知道类是什么，不知道的话，大概是要用接口
		Buyer o = (Buyer)a.newInstance();
		System.out.println(o.getClass());
		//通过构造器来新建对象，这里的思路就很值得思考了。都是参数。
		Constructor constructor=a.getConstructor(String.class, int.class, int.class, String.class, int.class,String.class);
		System.out.println(constructor.newInstance("大爷", 11, 12, "嗨呀μ", 30, "我擦"));
		//通过反射来调用方法
		Method methodset1 = a.getMethod("setName", String.class);
		Method methodset2 = a.getMethod("setSex", String.class);
		methodset1.invoke(o,"你大爷");
		methodset2.invoke(o,"不男不女");
		System.out.println(o.getName()+" "+o.getSex());
		//反射操作属性
		Buyer buyer1=(Buyer)a.newInstance();
		Field f1 = buyer1.getClass().getDeclaredField("sex");
		f1.setAccessible(true);
		f1.set(buyer1,"man");
		System.out.println(buyer1.getSex());
		//父类的属性设置需要用父类的来操作
		Field f2 = buyer1.getClass().getSuperclass().getDeclaredField("name");
		f2.setAccessible(true);
		f2.set(buyer1,"付雷鸣");
		System.out.println(buyer1.getName());
		//反射操作泛型
		Method hashmethod = test.class.getMethod("getMap", HashMap.class, List.class);
		Type[] genericParameterTypes = hashmethod.getGenericParameterTypes();
		System.out.println("*************");
		for (int i = 0; i < genericParameterTypes.length; i++) {
			System.out.println("*"+genericParameterTypes[i].getTypeName());
			if(genericParameterTypes[i] instanceof ParameterizedType){
				Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments();
				for (Type actualTypeArgument : actualTypeArguments) {
					System.out.println(actualTypeArgument.getTypeName());
				}
			}
		}
		Type genericReturnType = hashmethod.getGenericReturnType();
		System.out.println(genericReturnType.getTypeName());
		//反射操作注解
		//获得类注解
		Class s = Class.forName("javaCoreOne.reflection.Student");
		Annotation[] annotations = s.getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			System.out.println(annotations[i]);
		}
		//获取注解value
		StuClassAnotation annotation = (StuClassAnotation)s.getAnnotation(StuClassAnotation.class);
		System.out.println(annotation.value());
		//获得类指定值注解
		Field name = s.getDeclaredField("name");
		StuField f = name.getAnnotation(StuField.class);
		System.out.println(f.columeName());
		System.out.println(f.length());
		System.out.println(f.type());
	}

	public static HashMap<String,Integer> getMap(HashMap<String,Integer> map, List<String> list){
		System.out.println("getMap");
		return null;
	}



}
/*
学生类的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface StuClassAnotation{
	String value() default "Student";
}
/*
值域的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface StuField{
	String columeName();
	String type();
	int length();
}

@StuClassAnotation
class Student{
	@StuField(columeName="name",type = "varchar",length = 10)
	String name;
	@StuField(columeName="id",type = "int",length = 10)
	int id;
	@StuField(columeName="sex",type = "varchar",length = 3)
	String sex;

	public Student() {
	}

	public Student(String name, int id, String sex) {
		this.name = name;
		this.id = id;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}

class User{
	private String name;
	private int id;
	private int age;

	public User() {

	}

	public User(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
class Buyer extends User{
	private String province;
	private int income;
	private String sex;

	public Buyer(){

	}
	public Buyer(String province, int income, String sex) {
		this.province = province;
		this.income = income;
		this.sex = sex;
	}

	public Buyer(String name, int id, int age, String province, int income, String sex) {
		super(name, id, age);
		this.province = province;
		this.income = income;
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
