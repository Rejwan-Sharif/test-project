package com.test;

import com.test.springParactice.basicSpring.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.annotation.ApplicationScope;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;



@EnableAsync
@SpringBootApplication
@Slf4j
public class Test {

    @Bean
public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("file:D:\\my-projects\\messages_bangla");
        messageSource.setCacheSeconds(10);
        messageSource.setDefaultEncoding(StandardCharsets.ISO_8859_1.displayName());
        return messageSource;
    }

    public static void main(String[] args) {
       SpringApplication.run(Test.class, args);

//       while (true) {
//           Locale bn = new Locale(" ");
//           String message = context.getMessage("hello.i18n.message", null, Locale.US);
//           System.out.println(message);
//       }
    }

   



}
