package com.test.designPettern.pubsub;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final List<Subscriber>subscribers = new ArrayList<>();

    public void subscribers(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(String notification){
        notifyToAllSubscriber(notification);
    }

    private void notifyToAllSubscriber(String notification){
        for (Subscriber subscriber :subscribers){
            subscriber.notify("Hello "+subscriber.getSubscriberName()+","+notification);
        }
    }
}

