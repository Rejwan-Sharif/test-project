package com.test.designPettern.abstractFactoryMethod;

public class LaptopFactory  implements DeviceFactory{

     public Laptop createDevice(String name) throws Exception{
        if ("hp".equalsIgnoreCase(name)){
            return new Hp();
        }else if ("dell".equalsIgnoreCase(name)){
            return new Dell();
        }
        throw new RuntimeException("No Laptop Found");
    }


}
