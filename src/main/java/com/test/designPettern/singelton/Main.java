package com.test.designPettern.singelton;

public class Main {

    public static void main(String args []){

        ProductDao productDao = ProductDao.getInstance();
        ProductDao productDao1 = ProductDao.getInstance();

        System.out.println(productDao);
        System.out.println(productDao1);

    }
}
