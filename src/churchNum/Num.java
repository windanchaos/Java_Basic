package churchNum;

/**
 * ClassName: Num <br/>
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年10月7日 下午10:45:21 <br/>
 * 
 * @author chaosbom
 * @version
 * @since JDK 1.8
 * 
 * @modified By： <修改人> <br/>
 * @modified Date:<修改日期> <br/>
 * @desc：修改日志 <修改描述> <br/>
 */
public interface Num{
    public static Num zero = new NextOne(null);
    abstract int get();
}
 
final class Zero implements Num {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Zero;
    }
 
    Zero() {
        NextOne.i = 0;
    }
    @Override
    public String toString() {
        return  "zero";
    }
 
    @Override public int get() {
        return 0;
    }
 
}
 
final class NextOne implements Num {
    static int i = 0;
//    public static Num zero = new NextOne(null);
    Num pre;//predecessor
 
    NextOne(Num pre) {
        this.pre = pre;
        i++;
    }
 
    @Override
    public String toString() {
        return pre == null ? "zero" : "new " + NextOne.class.getSimpleName() + "(" + pre + ")";
    }
 
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof NextOne)
                ? pre.equals(((NextOne) obj).pre)
                : false;
    }
 
    @Override public int get() {
        return i;
    }
}
