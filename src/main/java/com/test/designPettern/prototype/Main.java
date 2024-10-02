package com.test.designPettern.prototype;

import java.time.Duration;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{



        String[] data = dataOverNetwork();
        DataSource db = new DataSource();

        db.setUrl(data[0]);
        db.setUsername(data[1]);
        db.setPassword(data[2]);

        System.out.println(Arrays.toString(data));


         DataSource db2 = db.clone();
        System.out.println(db2.hashCode());
        System.out.println(db.hashCode());


        Student student = new Student("rakib","12",new Address("12","Khan vila"));

        Student student1 = student.clone();

        student1.getAddress().setHouseName("Akaash Holdings");

        System.out.println(student);
        System.out.println(student1);


    }

    public static String[] dataOverNetwork() throws InterruptedException{
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        return new String [] {"http://localhost:8080/my_db","myUser","1234"};
    }

}
