package com.test.designPettern.abstractFactoryMethod;

public class Main {

    public static void main(String[] args) throws Exception{

            Device device = AbstractFactory.createFactory("laptop-factory").createDevice("hp");
            device.info();

    }
}
