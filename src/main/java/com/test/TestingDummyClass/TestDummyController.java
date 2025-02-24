package com.test.TestingDummyClass;

import com.test.errorHandling.MathException;
import com.test.errorHandling.ResourceNotFoundException;
import com.test.services.RemoteServerCallService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class TestDummyController {

    private final MathClass mathClass;
    private final RemoteServerCallService rmi;

    @GetMapping("/api")
    public String getApi(){
        return rmi.getData().toString();
    }

    @GetMapping("/aspect")
    public String getData(){

      int a=  mathClass.sum(1,2,4);
        int b = mathClass.sum(3,4,6,8);
        String value1= String.valueOf(a);
        String value2 = String.valueOf(b);
        return value2;
    }


    @GetMapping("/calculate")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b){
        if (b==0){
            throw new MathException("The value of b, can not be Zero");
        }
        return a/b;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("id")String a){
       return Arrays.asList("a","b","c").stream()
               .filter(s -> s.equals(""))
               .findFirst()
               .orElseThrow(()->new ResourceNotFoundException("The Resouse Not Found"));
    }

}
