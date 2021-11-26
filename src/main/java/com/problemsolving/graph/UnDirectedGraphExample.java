package com.problemsolving.graph;

import java.util.*;

public class UnDirectedGraphExample {
    public static void main(String[] args) {
        Map<String, List<String>> adjList =  buildAdjList(new String[][]{{"i","j"},{"k","i"},{"m","k"},{"k","l"},{"o","n"}});
        System.out.println(hasPath(adjList,"l","o"));
        System.out.println(dlpRecursiveImpl(adjList,"l","o",new HashSet<>()));
    }

    private static Map<String, List<String>> buildAdjList(String[][] edges){
        Map<String, List<String>> adjList = new HashMap<>();
        for(String[] edge : edges){
            if(adjList.containsKey(edge[0])){
                adjList.get(edge[0]).add(edge[1]);
            } else {
                List<String> neighbor = new ArrayList<>();
                neighbor.add(edge[1]);
                adjList.put(edge[0],neighbor);
            }
            if(adjList.containsKey(edge[1])){
                adjList.get(edge[1]).add(edge[0]);
            } else {
                List<String> neighbor = new ArrayList<>();
                neighbor.add(edge[0]);
                adjList.put(edge[1],neighbor);
            }
        }
        return adjList;
    }

    // Time -> O(e) Space->O(n) e can be n*n
    private static boolean hasPath(Map<String, List<String>> adjList, String startNode, String endNode){
        Set<String> alreadyVisitedNode = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            String element = stack.pop();
            alreadyVisitedNode.add(element);
            if(element.equalsIgnoreCase(endNode)){
                return true;
            }

            if(adjList.containsKey(element)) {
                for (String neighbor : adjList.get(element)){
                    if(!alreadyVisitedNode.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }
        }
        return false;
    }

    private static boolean dlpRecursiveImpl(Map<String, List<String>> adjList, String startNode, String endNode,Set<String> alreadyVisited){
        if(alreadyVisited.contains(startNode)){
            return false;
        }
        if(startNode.equalsIgnoreCase(endNode)){
            return true;
        }
        alreadyVisited.add(startNode);
        if(adjList.containsKey(startNode)) {
            for(String neighbor : adjList.get(startNode)){
                if(dlpRecursiveImpl(adjList,neighbor,endNode,alreadyVisited)){
                    return true;
                }
            }
        }
        return false;
    }
}
