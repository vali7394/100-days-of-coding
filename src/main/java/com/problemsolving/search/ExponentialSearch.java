package com.problemsolving.search;

import java.util.Arrays;

public class ExponentialSearch {
    public static void main(String[] args) {
        int arr[] = {10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47};
        System.out.println(expoSearch(arr,19));
    }

    private static int expoSearch(int[] arr , int k){
        int result = -1;
        if(arr==null || arr.length==0){
            return result;
        }
        if(arr[0]==k){
            return 0;
        }
        int i=1;
        while (i<arr.length && arr[i]<=k){
            if(arr[i]==k){
                return i;
            }
            i=i*2;
        }
        return binarySearch(arr,i/2,Math.min(i,arr.length-1),k);
    }

    private static int binarySearch(int[] input,int low, int high,  int k){
        if(low >high){
            return -1;
        }
        while (low<=high){
            int mid = (low+high)/2;
            if(input[mid]==k){
                return mid;
            }
            if(input[mid]<k){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

}
