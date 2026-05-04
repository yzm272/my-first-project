package org.example.designFactory.simple;

public class Consumer {
    public static  void  main(String[] args){
        /**
         * 太老土，因为这个还得知道，我去调用还得知道怎么实例化。，还得传参数，也是解耦合
         */
//        Car  car=new Wuling();
//        Car car2=new Tesla();
//        car.name();
//        car2.name();

        /**
         * 2使用工厂
         */
        Car  car=CarFactory.getCar("特斯拉");
        car.name();

        Car   car2=CarFactory.getCar("五菱");
        car2.name();
        /**
         * 3 这个时候新增加一个这个大众的时候就需要进行修改工厂类的判断代码 ，这个就是违法开闭原则，每次得改工厂类，还是不太方便
         */
    }
}
