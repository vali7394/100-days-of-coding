package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly With Wings");
    }
}
