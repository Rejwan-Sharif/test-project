package com.test.projectionsTesting;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerPrimaryDataController {

//    @Autowired
//    private CustomerPrimaryDataService customerPrimaryDataService;

//    @GetMapping("/data")
//    List<AccountBasicInfoProjection> getData(@RequestParam(required = false) String account,
//                                         @RequestParam(required = false) String card) throws Exception{
//        return  //customerPrimaryDataService.getCustomerPrimaryData(account,card);
//    }

}
