package com.com.multithreading;

import java.util.List;

/**
 * @Author: Meeravali Shaik
 * Date: 6/10/22
 */
public class Test {
    public static void main(String[] args) {
       List.of(2,4,1,10,6,9,7,3,8,5)
               .stream()
               .sorted()
               .skip(2)
               .limit(3)
               .forEach(System.out::println);
    }
}
