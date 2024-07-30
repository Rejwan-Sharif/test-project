package com.test.designPettern.factoryPettern;

public class Huawei implements Phone {

   private Double price;

   Huawei(Double price){
       this.price = price;
   }

    @Override
    public void info(){
        System.out.println("This IS power house of camera");
    }
}
