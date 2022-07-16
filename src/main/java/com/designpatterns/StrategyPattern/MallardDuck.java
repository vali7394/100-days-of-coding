package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class MallardDuck extends Duck{

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is MallardDuck");
    }
}
