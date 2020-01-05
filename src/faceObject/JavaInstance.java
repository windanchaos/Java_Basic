package faceObject;

import org.openjdk.jol.info.ClassLayout;

public class JavaInstance {
    static T t =new T();
    public static void main(String[] args) {
        //window的cpu小端存储，倒着来。hashcode，取的内存中的地址。
        System.out.println(Integer.toHexString(t.hashCode()));
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        /*对象布局（原则大小bytes数是8的倍数）：
        - 对象头
        - 实例数据
        - 对齐数据
         OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
      0     4                     (object header)                           21 00 00 00 (00100001 00000000 00000000 00000000) (33)
      4     4                     (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4                     (object header)                           43 c1 00 20 (01000011 11000001 00000000 00100000) (536920387)
     12     1             boolean T.bol                                     false
     13     3                     (alignment/padding gap)
     16     4   java.lang.Integer T.i                                       null
     20     4    java.lang.Double T.d                                       null
     24     4    java.lang.String T.s                                       null
     28     4                     (loss due to the next object alignment)
    Instance size: 32 bytes
    Space losses: 3 bytes internal + 4 bytes external = 7 bytes total
         */

    }
}
class T{
    boolean bol;
    Integer i;
    Double d;
    String s;
}
