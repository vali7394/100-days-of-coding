package com.learning.binarysearch;

import java.util.*;
import java.util.stream.Collectors;

/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:

Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].


Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */
public class WeakestRowInMatrix {

    public static void main(String[] args) {
        int[][] input = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        kWeakestRows(input,3);
    }

    public int[] kWeakestRowsBf(int[][] mat, int k) {
        int[] result = new int[k];

        if(mat==null || mat.length==0 || k<=0){
            return new int[]{};
        }

        Map<Integer,Integer> rowTracker = new HashMap<>();

        for(int i=0; i<mat.length; i++) { // -> O(mn)
            int count=0;
            for(int j=0;j<mat[0].length; j++) {
                if(mat[i][j]==0){
                    break;
                }
                count++;
            }
            rowTracker.put(i,count);
        }

        return rowTracker.entrySet().stream().sorted((rowI, rowJ) -> {
            if(rowI.getValue().compareTo(rowJ.getValue())==0){
                return rowI.getKey().compareTo(rowJ.getKey());
            }
            return rowI.getValue().compareTo(rowJ.getValue());
        }).mapToInt(Map.Entry::getKey).limit(k).toArray();

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        if(mat==null || mat.length==0 || k<=0 || k>mat.length){
            return new int[]{};
        }
        int m = mat.length;
        PriorityQueue<int[]> helper = new PriorityQueue<int[]>((row,rowj)->{
            if(row[1]==rowj[2]) {
                return rowj[0]-row[0];
            }
            return rowj[1]-row[0];
        });
        int i=m-1;
        int n = m-k;
        int[] result = new int[k];
        int count = 0;
        while (i>=0){
            int index = firstOccurrenceOfZero(mat[i]);
                if(n>0 && index==-1){
                    n--;
                } else {
                    helper.add(new int[]{i,index==-1?m:index});
                }
                i--;
        }

        for(int l=k-1; l>=0; l--){
            result[l]=helper.poll()[0];
        }

        return result;
    }

    private static int firstOccurrenceOfZero(int[] input){
        int low = 0;
        int high = input.length-1;
        int firstOccurrence = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(input[mid]==0){
                firstOccurrence = mid;
                high = mid-1;
            } else if(input[mid]==1){
                low=mid+1;
            } else {
                high = mid-1;
            }
        }
        return firstOccurrence;
    }

}
