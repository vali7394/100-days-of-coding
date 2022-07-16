package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I’m fl ying with a rocket!");
    }
}
