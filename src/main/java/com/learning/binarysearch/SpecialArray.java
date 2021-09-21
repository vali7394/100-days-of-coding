package com.learning.binarysearch;

import java.util.HashMap;
import java.util.Map;

public class SpecialArray {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
    public static int specialArray(int[] nums) {
        int result = -1;
        if (nums==null || nums.length==0){
            return result;
        }
        Map<Integer,Integer> tracker = new HashMap<>();
        for(int i=0; i<=nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[j]>=i){
                    tracker.put(i,tracker.getOrDefault(i,0)+1);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry : tracker.entrySet()){
            if(entry.getKey().compareTo(entry.getValue())==0){
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
    public int specialArrayO(int[] nums) {
        int low = 0, high = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = getCount(nums, mid);
            if(count == mid) return mid;
            if(count > mid) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    private int getCount(int nums[],int mid){
        int count = 0;
        for(int x : nums) if(x >= mid) count++;
        return count;
    }
}
