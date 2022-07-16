package com.designpatterns.observerpattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/15/22
 */
public interface Subject {
    void registerObserver(ObserverTemp observer);
    void removeObserver(ObserverTemp observer);
    void notifyObserver();
}
