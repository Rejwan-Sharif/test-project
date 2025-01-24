package com.test.designPettern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Cloneable{

    private String name;
    private String gender;
    private Address address;

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();

        String roadNo = s.getAddress().getRoadNo();
        String house = s.getAddress().getHouseName();

        Address newAddress = new Address(roadNo,house);
        s.setAddress(newAddress);
        return s;
    }

}
