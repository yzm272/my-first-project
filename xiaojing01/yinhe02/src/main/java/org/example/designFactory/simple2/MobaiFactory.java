package org.example.designFactory.simple2;

public class MobaiFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Mobai();
    }
}
