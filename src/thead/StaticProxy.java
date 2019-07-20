/**
 * Project Name:Java_Basic
 * File Name:StaticProxy.java
 * Package Name:thead
 * 静态代理设计模式：
 * 1、真是角色
 * 2、代理角色
 * 3、二者实现相同接口
 * 4、代理类中持有真实角色
 */
package thead;

public class StaticProxy {
    public static void main(String[] args) {
        Weddingcompany weddingcompany=new Weddingcompany(new You("Kate"));
        weddingcompany.marry();
    }
}

// 接口
interface Marry {
    void marry();
}

// 真实
class You implements Marry {

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     *
     * @see thead.Marry#marry()
     */
    String name;

    public You(String name) {
        this.name = name;
    }

    @Override
    public void marry() {
        System.out.println(this.name + "结婚了");
    }
}

// 代理
class Weddingcompany implements Marry {

    private You you;

    public Weddingcompany(You you) {
        this.you = you;
    }

    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }

    private void before() {
        System.out.println("准备婚房");
        System.out.println("准备酒店");
    }

    private void after() {
        System.out.println("闹洞房");
    }
}