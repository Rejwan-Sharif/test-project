package com.test.springParactice.basicSpring;

//import com.test.Test;
//import com.test.springParactice.basicSpring.scope.TimedBean;
//import com.test.springParactice.basicSpring.scope.TimedScope;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@ComponentScan(
        basePackages = "springPractice.basicSpring"
)
public class Main {


    public static void main(String[] args) throws Exception{


       // ApplicationContext context = new ClassPathXmlApplicationContext("OurBean.xml");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Student student= context.getBean("student",Student.class);
        Address address= context.getBean("address",Address.class);

        Result result = context.getBean("result", Result.class);

        SingeltoneBean sb = context.getBean("singeltoneBean",SingeltoneBean.class);
        sb.execute();
        sb.execute();
        sb.execute();
        sb.execute();

        System.out.println(result);

//        creating new scope
//        context.getBeanFactory().registerScope("timed", new TimedScope());
//
//        Thread.sleep(4000);
//        System.out.println(context.getBean(TimedBean.class) +" Timed Scope");
//        Thread.sleep(2000);
//        System.out.println(context.getBean(TimedBean.class) +" Timed Scope");
//        Thread.sleep(2000);
//        System.out.println(context.getBean(TimedBean.class) +" Timed Scope");
//        Thread.sleep(4000);
//        System.out.println(context.getBean(TimedBean.class) +" Timed Scope");

        System.out.println(context.getBean(DatabaseConnector.class));
//        System.out.println(student);
//        System.out.println(address);



    }

}
