package design_pattern.decorator.demo1;


//四年级成绩单
public class FouthGradeSchoolReport extends SchoolReport{
    //我的成绩单
    public void report(){
        //成绩单的格式是这个样子的
        System.out.println("尊敬的XXX家长：");
        System.out.println("······");
        System.out.println("语文62 数学65 体育98 自然63");
        System.out.println("······");
        System.out.println("      家长签字");
    }
    //家长签名
    public void sign(String name){
        System.out.println("家长签字为：" + name);
    }
}