package com.problemsolving.stack;

import java.util.Stack;

/**
 * @Author: Meeravali Shaik
 * Date: 7/8/22
 */
public class BrowserHistory {

    Stack<String>  currentPage;
    Stack<String> history;

    public BrowserHistory(String homepage) {
        this.currentPage = new Stack<>();
        this.history = new Stack<>();
        currentPage.push(homepage);
    }

    public void visit(String url) {
        history.push(currentPage.pop());
        currentPage.push(url);
    }

   /* public String back(int steps) {

    }

    public String forward(int steps) {

    }*/
}
