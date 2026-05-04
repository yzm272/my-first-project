package org.example.designFactory.simple2;

public class Consumer {
    public static void main(String[] args) {

        /**
         * 3 这个时候新增加一个这个大众的时候就需要进行修改工厂类的判断代码 ，这个就是违法开闭原则，每次得改工厂类，还是不太方便
         * 所以现在是这个 工厂 方法模式
         */
        Car car = new WulingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        Car car3 = new MobaiFactory().getCar();
        car.name();
        car2.name();
        car3.name();

    }
}
