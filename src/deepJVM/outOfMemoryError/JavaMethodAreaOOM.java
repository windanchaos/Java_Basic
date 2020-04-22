package deepJVM.outOfMemoryError;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区内存溢出，借助CGLib字节码技术
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:PermSize5m -XX:MaxPermSize5m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class JavaMethodAreaOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer= new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }
}
