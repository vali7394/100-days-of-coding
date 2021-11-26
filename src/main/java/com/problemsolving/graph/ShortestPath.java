package com.problemsolving.graph;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        String[][] edges = new String[][]{{"w","x"},{"x","y"},{"z","y"},{"z","v"},{"w","v"},{"a","b"}};
        System.out.println(shortestPath(buildAdjList(edges),"w","a"));
    }


    private static Map<String, List<String>> buildAdjList(String[][] edges){
        Map<String, List<String>> adjList = new HashMap<>();
        for(String[] edge : edges){
            if(adjList.containsKey(edge[0])){
                adjList.get(edge[0]).add(edge[1]);
            }else {
                List<String> neighbors = new ArrayList<>();
                neighbors.add(edge[1]);
                adjList.put(edge[0],neighbors);
            }
            if(adjList.containsKey(edge[1])){
                adjList.get(edge[0]).add(edge[1]);
            }else {
                List<String> neighbors = new ArrayList<>();
                neighbors.add(edge[0]);
                adjList.put(edge[1],neighbors);
            }
        }
        return adjList;
    }

    private static int shortestPath(Map<String, List<String>> adjList,String startNode, String endNode){
        if(startNode.equalsIgnoreCase(endNode)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Deque<Path> queue = new LinkedList<>();
        queue.add(new Path(startNode,0));
        while (!queue.isEmpty()){
            Path path = queue.poll();
            if(!visited.contains(path.getNode())){
                visited.add(path.getNode());
                if(path.getNode().equalsIgnoreCase(endNode)){
                    return path.getPathSize();
                }
                if(adjList.containsKey(path.getNode())){
                    for(String neighbor : adjList.get(path.getNode())){
                        queue.add(new Path(neighbor,path.getPathSize()+1));
                    }
                }

            }
        }
        return -1;
    }


}

class Path {
    private String node;
    private int pathSize;

    public Path(String node, int pathSize) {
        this.node = node;
        this.pathSize = pathSize;
    }

    public String getNode() {
        return node;
    }

    public int getPathSize() {
        return pathSize;
    }

}