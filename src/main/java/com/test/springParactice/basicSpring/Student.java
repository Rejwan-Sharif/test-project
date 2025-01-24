package com.test.springParactice.basicSpring;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
public class Student implements InitializingBean{


    private  String name;
    private List<String> roll;
    private String gender;
    private Address address;



    public Student() {
        System.out.println("this is constructor");
    }


    public void setRoll(List<String> roll) {
        this.roll = roll;
    }


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set");
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
