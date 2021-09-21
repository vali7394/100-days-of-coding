package com.learning.binarysearch;

/*
Intersection of Two Arrays
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */

/*
Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */

import java.util.*;

public class ArrayIntersection {


    public int[] intersectionI(int[] nums1, int[] nums2) {
        if(nums1 ==null || nums2==null || nums1.length==0 || nums2.length==0) {
            return new int[] {};
        }
        Set<Integer> helperMap = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int num1 : nums1){
            helperMap.add(num1);
        }

        for(int num : nums2){
            if(helperMap.contains(num)){
                result.add(num);
            }
        }
        return result.stream().mapToInt(Number::intValue).toArray();
    }

    public int[] intersectII(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) {
            return new int[]{};
        }

        Map<Integer,Integer> helperMap = new HashMap<>();
        List<Integer> resultHelper = new ArrayList<>();
        for(int i : nums1){
            helperMap.put(i,helperMap.getOrDefault(i,0)+1);
        }

        for(int i : nums2){
            if(helperMap.containsKey(i) && helperMap.get(i)>0){
                resultHelper.add(i);
                helperMap.put(i,helperMap.get(i)-1);
            }
        }
        int[] result = new int[resultHelper.size()];
        int count=0;
        for(int i : resultHelper){
            result[count] = i;
            count++;
        }
        return result;
    }


}
