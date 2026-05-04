package org.example.designFactory.simple;

public class CarFactory {
//    静态方法工厂模式，增加新增一个类，就得改代码
    public static Car  getCar(String car){
        if(car.equals("五菱")){
            return  new Wuling();
        }else if(car.equals("特斯拉")){
            return  new Tesla();
        }else{
            return null;
        }
    }




}
