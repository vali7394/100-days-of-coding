package com.learn.hundred.days.coding.slidingwindow;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Meeravali Shaik
 * Date: 6/9/22
 */
public class SubStringKDistinct {


    public static void main(String[] args) {
        while (true) {
            try {
                Robot robot = new Robot();
                final int x = MouseInfo.getPointerInfo().getLocation().x;
                final int y = MouseInfo.getPointerInfo().getLocation().y;
                robot.mouseMove(x + 50, y + 50);
                Thread.sleep(150);
                robot.mouseMove(x, y);
                Thread.sleep(20000);
            } catch (AWTException | InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    private String longestSubStringWithKDistinct(String input, int k){
        if(input==null || input.isEmpty() || input.length() < k){
            return input;
        }

        Set<Character> uniqueTracker = new HashSet<>(k+1);
        int i=0, j=0, size=Integer.MIN_VALUE;
        String result = "";
        StringBuilder temp = new StringBuilder();
        /*while (i<input.length() && j<i){
            uniqueTracker.add(input.charAt(i));
            if(uniqueTracker.size()>k){
                result.
            }
        }*/
        return "";
    }

}
