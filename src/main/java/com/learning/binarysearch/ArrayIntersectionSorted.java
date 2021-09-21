package com.learning.binarysearch;

/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.



Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersectionSorted {

    public static void main(String[] args) {
      //  int[] arr1 = {1,2,3,4,5}, arr2 = {1,2,5,7,9}, arr3 = {1,3,4,5,8};
        int[] arr1 = {197,418,523,876,1356}, arr2 = {501,880,1593,1710,1870}, arr3 = {521,682,1337,1395,1764};
        System.out.println(arraysIntersectionBf(arr1,arr2,arr3));
    }

    public static List<Integer> arraysIntersectionBf(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        if(arr1==null || arr2==null || arr3==null || arr1.length==0 || arr2.length==0 || arr3.length==0) {
            return result;
        }
        for(int i : arr1) {
            if(Arrays.binarySearch(arr2,i) >=0 && Arrays.binarySearch(arr3,i)>=0){
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> arraysIntersectionEs(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        if(arr1==null || arr2==null || arr3==null || arr1.length==0 || arr2.length==0 || arr3.length==0) {
            return result;
        }
        for(int i=0,j=0,k=0 ; i<arr1.length && j<arr2.length && k<arr3.length;){
            if(arr1[i]==arr2[j] && arr1[i]==arr3[k]){
                result.add(arr1[i]);
            }
            int minVal = Integer.min(Integer.min(arr1[i],arr2[j]),arr3[k]);
            if (arr1[i]==minVal) i++;
            if (arr2[j]==minVal) j++;
            if (arr2[k]==minVal) k++;
        }
        return result;
    }

}
