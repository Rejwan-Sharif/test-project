package com.test.customInterceptor;

import org.springframework.stereotype.Component;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class RequestRepo {

    private final List<InfoDto> tracker = new CopyOnWriteArrayList<>();

    public void addRequestTracker(InfoDto dto){
        tracker.add(dto);
    }
    public List<InfoDto>getTracker(){
        return Collections.unmodifiableList(new ArrayList<>(tracker));
    }



}
