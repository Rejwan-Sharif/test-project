package com.test.designPettern.factoryPattern;

public class Main {

    public static void main(String[]args){
       Phone phoneFactory =  PhoneFactory.getPhone("Huawei");

        phoneFactory.info();

    }


}
