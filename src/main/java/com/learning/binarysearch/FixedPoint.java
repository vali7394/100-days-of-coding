package com.learning.binarysearch;
/*
Given an array of distinct integers arr, where arr is sorted in ascending order, return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.



Example 1:

Input: arr = [-10,-5,0,3,7]
Output: 3
Explanation: For the given array, arr[0] = -10, arr[1] = -5, arr[2] = 0, arr[3] = 3, thus the output is 3.
Example 2:

Input: arr = [0,2,5,8,17]
Output: 0
Explanation: arr[0] = 0, thus the output is 0.
Example 3:

Input: arr = [-10,-5,3,4,7,9]
Output: -1
Explanation: There is no such i that arr[i] == i, thus the output is -1.


Constraints:

1 <= arr.length < 104
-109 <= arr[i] <= 109

[-10,-5,-2,0,4,5,6,7,8,9,10]

low = o
high = 10
mid = 5

 */
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        if(arr==null || arr.length==0){
            return -1;
        }
        if(arr.length==1 && arr[0]!=0){
            return -1;
        }
        int low = 0;
        int high = arr.length-1;
        int smallestIndex = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(mid==arr[mid]){
                smallestIndex= mid;
                high = mid-1;
            } else if(mid<arr[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return smallestIndex;
    }
}
