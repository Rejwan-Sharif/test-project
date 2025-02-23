package com.test.designPettern.pubsub;

public class Subscriber {

    private final String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public void notify(String notification){
        System.out.println(notification);
    }

    public String getSubscriberName(){
        return this.subscriberName;
    }

}
