package com.com.multithreading;


import java.util.Random;

/**
 * @Author: Meeravali Shaik
 * Date: 4/11/22
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Random random = new Random();
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(10);
        Runnable producer = ()->{
            while (true){
                blockingQueue.put(createItem(random));
            }
        } ;

        new Thread(producer).start();
        new Thread(producer).start();


        Runnable consumer = ()->{
            while (true){
                System.out.println(blockingQueue.take());
            }
        } ;
        new Thread(consumer).start();
        new Thread(consumer).start();

    }

    private static int createItem(Random random){
        return random.nextInt();
    }
}
