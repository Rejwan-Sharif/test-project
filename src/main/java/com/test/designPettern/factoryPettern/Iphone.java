package com.test.designPettern.factoryPettern;

public class Iphone implements Phone{

    private String name;

    public Iphone(String name) {
        this.name = name;
    }

    @Override
    public void info(){
        System.out.println("This is iPhone");
    }

}
