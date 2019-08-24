package java300.practice;

import java.util.Date;

/*
152.	【上机】设计一个类代表二维空间的一个点
153.	【上机】设计一个类代表二维空间的一个圆。要求两个成员变量。一个是圆心，一
        个是半径提供计算面积的方法。
154.	【上机】为上述Cricle类添加一个方法，计算一个点（Point对象）是否在圆（Cricle
        对象）内，并写程序验证
212.	【上机】使用接口，定义电子产品系统(智能手机、MP3、智能手表)
214.	模拟实现Comparable和Comparator接口

 */
public class FaceObject {

}

class Circle{
    Point centerPoint;
    float radius;
    public Circle(Point centerPoint, float radius){
        this.centerPoint=centerPoint;
        this.radius=radius;
    }
    //计算面积
    public double getArea(){
        return Math.PI*radius*radius;
    }
    //计算给定点是否在圆内部
    public boolean checkPointInCircle(Point point){
        double distance=radius;
        distance=Math.sqrt(Math.pow(centerPoint.x-point.x,2)+Math.pow(centerPoint.y-point.y,2));
        return distance<radius;
    }
}
class Point{
    float x;
    float y;
    public Point(float x, float y){
        this.x=x;
        this.y=y;
    }
}
//电子产品接口
//智能手机、MP3、智能手表
interface power{
    //充电
    public void charge();
    //关机
    public void shutdown();
    //开机
    public void startUp();
    //获取状态
    public String getPowerStatus();
    //获取电量百分比
    public float getPowerCapacity();
    //电量模式
    public boolean setPowerModel(int model);

}
interface voice{
    //设置声音
    public boolean setVoiceVolume(int number);
    //设置声音模式
    public boolean setVoiceModel(int model);
}
interface musical{
    public void play(Song song);
    public boolean playList(Song[] songList);
    public boolean stop(Song song);
    public boolean playnext(Song song);

}

abstract class ProductInfo{
    String band;
    String area;
    String name;
    String dealer;
    float price;
    Date produceTime;
}

class Song{

}