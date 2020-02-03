package design_pattern.decorator.demo1;

//抽象成绩单
public abstract class SchoolReport {
    //展示成绩情况
    public abstract void report();
    //家长签字
    public abstract void sign(String name);
}