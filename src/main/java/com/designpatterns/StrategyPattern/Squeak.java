package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}
