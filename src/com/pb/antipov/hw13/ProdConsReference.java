package com.pb.antipov.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConsReference {
    public static void main(String args[]) {
        Queue<Integer> buffer = new LinkedList<>();
        final int maxSize = 5;
        Thread producer = new Producer(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
        producer.start();
        consumer.start();
    }
}
