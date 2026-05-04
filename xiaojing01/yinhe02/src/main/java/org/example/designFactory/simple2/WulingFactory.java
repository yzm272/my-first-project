package org.example.designFactory.simple2;


public  class WulingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
