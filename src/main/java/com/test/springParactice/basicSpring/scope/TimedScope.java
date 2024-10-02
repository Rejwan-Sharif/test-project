package com.test.springParactice.basicSpring.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimedScope implements Scope {

    private final Map<String, Object> timedBean = new ConcurrentHashMap<>();

    public TimedScope(){
        new Thread(this::cleanBean).start();
    }

    private void cleanBean(){

        while (true){
            try {
                Thread.sleep(5000);
                timedBean.clear();
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }



    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (timedBean.containsKey(s)){
            return timedBean.get(s);
        }
        Object bean = objectFactory.getObject();
        timedBean.put(s,bean);
        return bean;
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
