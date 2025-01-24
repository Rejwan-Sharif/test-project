package com.test.designPettern.abstractFactoryMethod;

public class AbstractFactory {

    public static DeviceFactory createFactory(String name){

        if ("phone-factory".equalsIgnoreCase(name)){
            return new PhoneFactory();
        }else if ("laptop-factory".equalsIgnoreCase(name)){
            return new LaptopFactory();
        }else{
            throw new RuntimeException("No Factory Found");
        }
    }

}
