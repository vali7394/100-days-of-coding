package com.problemsolving.graph;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{4,6},{5,6},{6,8},{6,7},{3,3}};
        Map<Integer, List<Integer>> adjList = buildAdjList(edges);
        System.out.println(countConnectedComponents(adjList));
    }


    private static int countConnectedComponents(Map<Integer, List<Integer>> adjList){
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int node : adjList.keySet()){
            if(visited.contains(node)){
                continue;
            }
            count++;
            recursiveDflImpl(adjList,node,visited);
        }
        return count;
    }

    private static void recursiveDflImpl(Map<Integer, List<Integer>> adjList, Integer startNode, Set<Integer> visited){
        if(!visited.contains(startNode)){
            visited.add(startNode);
            if(adjList.containsKey(startNode)) {
                for (int neighbor : adjList.get(startNode)) {
                    recursiveDflImpl(adjList,neighbor,visited);
                }
            }
        }

    }

    private static Map<Integer, List<Integer>> buildAdjList(int[][] edges){
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
}
