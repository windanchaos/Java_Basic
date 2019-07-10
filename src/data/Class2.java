package data;

import org.testng.annotations.Test;

/*
java.lang.class<T>
 */
public class Class2 {
    @Test
    public void test() {
        Integer a = new Integer(100);
        System.out.println(a.getClass());
    }

    @Test
    public void test1() {
        System.out.println(new Character('b').getClass());
        try {
            System.out.println(Class.forName("java.lang.Thread"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
