package com.problemsolving.graph;

import java.util.*;

public class LargestComponent {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,0},{5,0},{8,0},{5,8},{2,3},{2,4},{3,4}};
        Map<Integer, List<Integer>> adjList = adjList(edges);
        System.out.println(largestComponentInGraph(adjList));
    }

    private static Map<Integer, List<Integer>> adjList(int[][] edges){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            if(adjList.containsKey(edge[0])){
                adjList.get(edge[0]).add(edge[1]);
            }else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(edge[1]);
                adjList.put(edge[0],nodes);
            }
            if(adjList.containsKey(edge[1])){
                adjList.get(edge[1]).add(edge[0]);
            }else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(edge[0]);
                adjList.put(edge[1],nodes);
            }
        }
        return adjList;
    }

    private static int largestComponentInGraph(Map<Integer, List<Integer>> adjList){
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        for(int node : adjList.keySet()){
            if(!visited.contains(node)){
               // int count = dfsImpl(adjList,node,0,visited);
                int count = dfsStack(adjList,node,visited);
                result = Math.max(result,count);
            }
        }
        return result;
    }

    private static int dfsImpl(Map<Integer, List<Integer>> adjList, int node, int count, Set<Integer> visited){
        if(visited.contains(node)){
            return count;
        }
        count++;
        visited.add(node);
        if(adjList.containsKey(node)){
           for(int neighbor : adjList.get(node)){
               count = dfsImpl(adjList,neighbor,count,visited);
           }
        }
        return count;
    }

    private static int dfsStack(Map<Integer, List<Integer>> adjList, int node, Set<Integer> visited){
        Deque<Integer> stack  = new ArrayDeque<>();
        if(visited.contains(node)){
            return 0;
        }
        int count = 0;
        stack.push(node);
        while (!stack.isEmpty()) {
            int nodeTemp = stack.pop();
            if(!visited.contains(nodeTemp)) {
                visited.add(nodeTemp);
                count++;
                if (adjList.containsKey(nodeTemp)) {
                    for (int neighbor : adjList.get(node)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return count;
    }
}
