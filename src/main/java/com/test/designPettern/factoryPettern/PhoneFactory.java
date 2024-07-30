package com.test.designPettern.factoryPettern;


import org.apache.catalina.core.ApplicationContext;
import org.apache.naming.factory.BeanFactory;

public class PhoneFactory {

    public static Phone getPhone(String name){

        if (name == null)
            throw new IllegalArgumentException("name cant null");
        if ("iPhone".equalsIgnoreCase(name)){
            return new Iphone("This is iPhone");
        }else if("Huawei".equalsIgnoreCase(name)){
            return new Huawei(122.22);
        }
      throw new RuntimeException("No bean found");


    }
}
