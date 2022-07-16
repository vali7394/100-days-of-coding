package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }
}
