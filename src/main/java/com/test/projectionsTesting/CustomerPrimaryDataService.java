package com.test.projectionsTesting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerPrimaryDataService {

    @Autowired
    private CustomerPrimaryDataRepository customerPrimaryDataRepository;

    public List<AccountBasicInfoProjection> getCustomerPrimaryData(String account, String card){
        List<AccountBasicInfoProjection> projections = customerPrimaryDataRepository.findAccountPrimaryData(account,card);

        return projections;
    }

}
