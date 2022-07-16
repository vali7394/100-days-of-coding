package com.designpatterns.StrategyPattern;

/**
 * @Author: Meeravali Shaik
 * Date: 7/13/22
 */
public class DuckCall {

    QuackBehavior quackBehavior;

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        quackBehavior.quack();
    }
}
