package com.com.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Meeravali Shaik
 * Date: 4/11/22
 */
public class CustomBlockingQueue<T> {

    private Queue<T> queue;
    int size;
    ReentrantLock lock = new ReentrantLock();
    Condition emptyCondition = lock.newCondition();
    Condition fullCondition = lock.newCondition();

    public CustomBlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void put(T element){
        lock.lock();
        try {
            while (queue.size()==size){
                System.out.println("Waiting for Read before");
                fullCondition.await();
                System.out.println("Waiting for Read after");
            }
            queue.add(element);
            fullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            {
                lock.unlock();
            }
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                emptyCondition.await();
            }
            T item = queue.remove();
            emptyCondition.signalAll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


}
