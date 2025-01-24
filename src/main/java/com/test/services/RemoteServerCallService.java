package com.test.services;

import com.test.aspect.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class RemoteServerCallService {

    private final RestTemplate restTemplate;

    @Retry(exception = HttpClientErrorException.class, attemptsTime = 5, intervalTimes = 6000)
    public String getData(){
        return restTemplate.getForObject("https://www.youtubere.com/",String.class);
    }


}
