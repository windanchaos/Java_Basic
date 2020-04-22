package deepJVM.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:PermSize10m -XX:MaxPermSize10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class RuntimeConstantPoolOOM {
    //利用了Stirng.intern()方法,Returns a canonical representation for the string object.
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
