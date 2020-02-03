package design_pattern.decorator.demo1;

public class SortDecorator extends Decorator{
    //构造函数
    public SortDecorator(SchoolReport sr){
        super(sr);
    }
    //告诉老爸成绩的排名情况
    private void reportSort(){
        System.out.println("我排名是第38名...");
    }
    //老爸看完成绩单后再告诉他，加强作用
    public void report(){
        super.report();
        this.reportSort();
    }
}
