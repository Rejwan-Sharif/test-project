package com.test.designPettern.pubsub;

public class Main {


    public static void main(String[] args) {

        Publisher publisher = new Publisher();

        Subscriber s1 = new Subscriber("Rejwan");
        Subscriber s2 = new Subscriber("Raihan");
        Subscriber s3 = new Subscriber("Hannan");

        publisher.subscribers(s1);
        publisher.subscribers(s2);
//        publisher.subscribers(s1);


        publisher.publish("hello New video Uploded by ABC");

    }







}
