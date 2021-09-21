package com.learning.binarysearch;
/*
Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.

A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.



Example 1:

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.
Example 2:

Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(isMajorityElement(new int[]{2,4,5,5,5,5,5,6,6},5));
    }
    public static boolean isMajorityElement(int[] nums, int target) {
        boolean result = false;
        if(nums==null || nums.length==0){
            return result;
        }
        int first = findOccurrenceOfElement(nums,target,true);
        int last = findOccurrenceOfElement(nums,target,false);
        int totalOccurrence =  last==-1 || first==-1 ? 1 : last-first+1;
         return totalOccurrence>nums.length/2;
    }

    private static int findOccurrenceOfElement(int[] nums, int target, boolean findFirstOccurrence){
        int low =0;
        int high = nums.length-1;
        int occurrence = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target){
                occurrence = mid;
                if(findFirstOccurrence){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            } else if (nums[mid]<target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return occurrence;
    }
}
