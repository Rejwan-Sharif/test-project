package com.test.designPettern.builderDesignPettern;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private float cgpa;
    private Address address;

    public static class Builder{

        private long id;
        private String name;
        private float cgpa;
        private Address address;

        public  Builder id(long id){
            this.id =id;
            return this;
        }
        public  Builder name(String name){
            this.name =name;
            return this;
        }
        public  Builder cgpa(float cgpa){
            this.cgpa =cgpa;
            return this;
        }
        public  Builder address(Address address){
            this.address =address;
            return this;
        }
        public Student build(){
            return new Student(id,name,cgpa,address);
        }


    }
}

class Address{
    private long id;
    private String street;
    private String houseNo;
}