package com.test.TestingDummyClass;

import com.test.services.RemoteServerCallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
