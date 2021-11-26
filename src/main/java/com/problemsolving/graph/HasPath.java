package com.problemsolving.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HasPath {
    public static void main(String[] args) {
        System.out.println(
                hasPath(buildAdjacencyList(new String[][] {{"f","g"},{"f","i"},{"g","h"},{"i","g"},{"j","i"},{"i","k"}}),
                        "f","h"));
        System.out.println(
                recursiveHelper(buildAdjacencyList(new String[][] {{"f","g"},{"f","i"},{"g","h"},{"i","g"},{"j","i"},{"i","k"}}),
                        "f","h"));
    }

    private static Map<String, List<String>> buildAdjacencyList(String[][] edges){
        return Stream.of(edges)
                .collect(Collectors.groupingBy(edge->edge[0],Collectors.mapping(edge->edge[1],Collectors.toList())));
    }

    private static boolean hasPath(Map<String, List<String>> adjList ,String startNode, String endNode){
        Deque<String> stack = new ArrayDeque<>();
        stack.push(startNode);
        while (!stack.isEmpty()){
            String element = stack.pop();
            if(element.equalsIgnoreCase(endNode)){
                return true;
            }
            if(adjList.containsKey(element)) {
                for(String neighbor : adjList.get(element)){
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    private static boolean recursiveHelper(Map<String, List<String>> adjList ,String startNode, String endNode){
        if(startNode.equalsIgnoreCase(endNode)){
            return true;
        }
        if(adjList.containsKey(startNode)){
            for(String neighbor : adjList.get(startNode)){
                if(recursiveHelper(adjList, neighbor, endNode)){
                    return true;
                }
            }
        }
        return false;
    }
}
