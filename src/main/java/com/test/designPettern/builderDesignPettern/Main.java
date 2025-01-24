package com.test.designPettern.builderDesignPettern;

public class Main {

    public static void main(String[] args) {

        Student student = new Student.Builder().
                id(10)
                .cgpa(23.2f)
                .name("Jaman")
                .build();
        System.out.println(student.toString());
    }
}
