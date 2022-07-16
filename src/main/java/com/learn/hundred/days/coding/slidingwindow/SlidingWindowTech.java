package com.learn.hundred.days.coding.slidingwindow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Meeravali Shaik
 * Date: 6/8/22
 */
public class SlidingWindowTech {


    private static float[] avgOfKSubArrays(int[] input, int k){
        float[] result = new float[k];
        if(input==null || input.length==0 || input.length < k){
            return result;
        }
        int i=0;
        int resultCounter = 0;
        int sum=0;
        while (i<k){
            sum+=input[i];
            i++;
        }
        result[resultCounter++] = (float)sum/k;
        int j=0;
        while (i < input.length && j < i){
            sum=sum-input[j]+input[i];
            result[resultCounter++]=(float)sum/k;
            i++;
            j++;
        }
        return result;
    }

    private static int[] maxInEachSubArray(int[] input , int k){
        if(isInValidInput(input,k)){
            return new int[]{};
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i=0,j = 0, counter=0;
        int[] result = new int[input.length];
        while (i< k){
          heap.add(input[i]);
          i++;
        }
        result[counter++] = heap.peek();
        heap.remove(input[0]);
        while (i < input.length && j<i){
            heap.add(input[i++]);
            result[counter++] = heap.peek();
            heap.remove(input[j++]);
        }
        return result;
    }


    private static boolean isInValidInput(int[] input , int k){
       return input==null || input.length==0 || input.length < k;
    }

    public static void main(String[] args) {
        for (float i : avgOfKSubArrays(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5)) {
            System.out.print(i + " , ");
        }
        ;

       /* Queue<Integer> queue = new PriorityQueue<>(5);
        for (int i : new int[]{3, 1, 0, 0, 6}){
            queue.offer(i);
        }
            queue.remove(0);
        System.out.println(queue.size());*/
         //   System.out.println(queue.peek());
        for(int i : maxInEachSubArray(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6},3)) {
            System.out.println(i);
        }
    }

}
