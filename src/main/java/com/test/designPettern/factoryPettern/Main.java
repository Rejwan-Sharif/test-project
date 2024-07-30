package com.test.designPettern.factoryPettern;

public class Main {

    public static void main(String[]args){
       Phone phoneFactory =  PhoneFactory.getPhone("Huawei");

        phoneFactory.info();

    }


}
