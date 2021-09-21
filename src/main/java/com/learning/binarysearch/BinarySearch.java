package com.learning.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(findInCircularlyRotatedArray(new int[]{13,15,20,2,4,8,12},13));
    }


    private static int findElementBsItr(int[] input, int k){
        if(input==null || input.length==0) {
            return -1;
        }

        int low = 0;
        int high = input.length-1;

        while (low<=high) {
            int mid = (low+high)/2;
            if(input[mid]==k){
                return mid;
            }
            else if(input[mid] < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;

    }

    private static int findEleRec(int[] input, int k){
        if(input==null || input.length==0){
            return -1;
        }
        return findEleRecHelper(input,0,input.length-1,k);
    }

    private static int findEleRecHelper(int[] input, int low, int high, int k){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(input[mid]==k){
            return mid;
        } else if(input[mid] < k) {
            return findEleRecHelper(input,mid+1,high,k);
        } else {
            return findEleRecHelper(input,low,mid-1,k);
        }
    }

    /*
        2,4,10,10,10,18,20
     */

    private static int findFirstOccurrenceOfElement(int[] input, int k){
        if(input==null || input.length==0){
            return -1;
        }
        int low = 0;
        int high = input.length-1;
        int fistOcc = -1;

        while (low <= high){
            int mid = (low+high)/2;
            if(input[mid]==k) {
                fistOcc = mid;
                high = mid-1;
            } else if (input[mid] < k){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return fistOcc;
    }

    private static int findLastOccurrenceOfElement(int[] input, int k){
        if(input==null || input.length==0){
            return -1;
        }
        int low = 0;
        int high = input.length-1;
        int fistOcc = -1;

        while (low <= high){
            int mid = (low+high)/2;
            if(input[mid]==k) {
                fistOcc = mid;
                low = mid+1;
            } else if (input[mid] < k){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return fistOcc;
    }

    private static int findCountOfElemInSortedArray(int[] input, int k){
        if(input==null || input.length==0){
            return -1;
        }
        int firstOcu = findFirstOccurrenceOfElement(input,k);
        if(firstOcu==-1){
            return 0;
        }
        int lastOcu = findLastOccurrenceOfElement(input,k);
        return (lastOcu-firstOcu)+1;
    }

    private static int findRotatedTimes(int[] input){
        if(input==null || input.length==0){
            return -1;
        }
        int low = 0;
        int high = input.length-1;
        int n = input.length;

        while (low<=high) {
            int mid = (low+high)/2;
            int next = (mid+1)%n;
            int prec = (mid+n-1)%n;
            if(input[next] > input[mid] && input[mid] < input[prec]){
                return mid;
            } else if(input[mid] > input[high]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    private static int findInCircularlyRotatedArray(int[] input, int k) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int low = 0;
        int high = input.length - 1;
        while (low<=high){
            int mid = (low+high)/2;
            if(input[mid]==k){
                return mid;
            } else if(input[mid]<=input[high]) {
                if(input[mid]<k && k<=input[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else if(input[low]<=input[mid]){
                if(input[low]>=k && k<input[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }

        return -1;
    }

}
