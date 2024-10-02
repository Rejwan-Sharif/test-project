package com.test.designPettern.proxyPattern;

import com.test.springParactice.basicSpring.applicationEventPublisher.UserLoginEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Configuration

public class ProxyProduct implements Product{
  private  LiveProduct proxy = new LiveProduct();
private static Logger log = Logger.getLogger(ProxyProduct.class.getName());
  private
    //int arr [] ={2,5,1,4};

    @EventListener
    static  void getdata(ApplicationStartedEvent app){
        int arr [] ={2,5,1,4};
        ProxyProduct p = new ProxyProduct();
      System.out.println(p.getProduct(arr));


    }

    @Override // around Advice
    public int getProduct(int [] a) {

        long st = System.nanoTime(); // before advice
//        try {
            int total = proxy.getProduct(a);
//        }catch (Exception e){
            // after throwing advice
//        }
        long et = System.nanoTime(); // after advice

        log.info(String.format("total time consumned for sum = %d ", (st -et )+total));

        return total;
    }
}
