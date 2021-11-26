package com.problemsolving.graph;

import java.util.*;

public class IslandCount {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}};
        System.out.println(islandCount(grid));
    }


    private static int islandCount(int[][] input){
        int count = 0;
        boolean[][] visited = new boolean[input.length][input[0].length];
        for(int i=0; i<input.length ; i++){
            for(int j=0; j<input[0].length ; j++){
                if(input[i][j]==1 && !visited[i][j]){
                    dfsImpl(input,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfsImpl(int[][] input, int i , int j , boolean[][] visited){
        if(i<0 || j<0 || i>=input.length || j>=input[0].length
                || input[i][j]==0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfsImpl(input,i-1,j,visited);
        dfsImpl(input,i+1,j,visited);
        dfsImpl(input,i,j-1,visited);
        dfsImpl(input,i,j+1,visited);
    }
}
