package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can’t fly");
    }
}
