package com.problemsolving.search;

public class InterpolationSearch {

    public static void main(String[] args) {
        int arr[] = {10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47};
        System.out.println(searchAnElement(arr,47));
    }

    // Line Eq y = m*x +c where y->value x-> indx
    // arr[h] = m*h +c
    // arr[low] = m*l +c
    //arr[h]-arr[l] = m*(h-l) -> m = (arr[h]-arr[l])/(h-l)
    // y =
 // TS -> best case -> O(1) ac-> O(log(logn)) wc-> O(n)
    public static int searchAnElement(int[] input, int k){
        int result = -1;
        if(input==null || input.length==0){
            return result;
        }
        int low = 0;
        int high = input.length-1;

        while (low <=high) {
            int mid = (low) + ((k-input[low]) * (high-low)/(input[high]-input[low]));
            if(input[mid]==k){
                return mid;
            }
            if(input[mid] < k){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }
}
