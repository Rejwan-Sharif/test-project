package com.test.designPettern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {


    Map<String,List<Observar>>map = new HashMap<>();
//    List<Observar> studentList = new ArrayList<>();

    public void subscribe(String subject, Observar observar){
        List<Observar> list = map.computeIfAbsent(subject, k -> new ArrayList<>());
        list.add(observar);
    }

    public void publisher(String subject, String information){
        for (Observar observar : map.get(subject)){
            observar.info(information);
        }
    }
}
