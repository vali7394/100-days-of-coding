package com.learning.binarysearch;
/*
    Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 */
public class CountNegativies {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{1,-1},{-1,-1}}));
    }

    public static int countNegativesBf(int[][] grid) {
        int result = 0;
        if(grid==null || grid.length==0){
            return result;
        }
        for(int[] i : grid) {
            for(int j : i){
                if(j <0) {
                    result ++;
                }
            }
        }
        return result;
    }

    public static int countNegatives(int[][] grid) {
        int result = 0;
        if(grid==null || grid.length==0){
            return result;
        }
        int m = grid.length;
        int n = grid[0].length;
        int i=0;
        while(i<m){
            if(grid[i][n-1]>=0){
                i++;
                continue;
            }
                int j=n-1;
                while (j>=0){
                    if(grid[i][j]>=0){
                        break;
                    } else {
                        result++;
                        j--;
                    }

                }
                i++;
        }
        return result;
    }
}
