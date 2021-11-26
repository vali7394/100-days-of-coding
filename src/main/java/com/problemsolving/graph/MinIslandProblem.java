package com.problemsolving.graph;

public class MinIslandProblem {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,1,0},
                {1,1,1,1,1}};
        System.out.println(findMinIsland(grid));
    }

    private static int findMinIsland(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minIslandCount = Integer.MAX_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int result = dflImpl(grid,i,j,visited);
                    if(result!=0) {
                        minIslandCount = Math.min(minIslandCount, result);
                    }
                }
            }
        }
        return minIslandCount;
    }

    private static int dflImpl(int[][] grid,int i, int j,boolean[][] visited){
            if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visited[i][j]){
                return 0;
            }
            int count = 1;
            visited[i][j] = true;
            count+=dflImpl(grid,i-1,j,visited);
            count+=dflImpl(grid,i+1,j,visited);
            count+=dflImpl(grid,i,j-1,visited);
            count+=dflImpl(grid,i,j+1,visited);
            return count;
    }
}
