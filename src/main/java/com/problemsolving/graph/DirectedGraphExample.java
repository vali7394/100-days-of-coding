package com.problemsolving.graph;


import java.util.*;
import java.util.stream.Collectors;

public class DirectedGraphExample {
    public static void main(String[] args) {
        String[][] edges = new String[][] {{"a","c"},{"a","b"},{"b","d"},{"c","e"},{"d","f"}};
       // System.out.println(buildAdjacencyList(edges));
        Map<String,List<String>> adjacencyList = buildAdjacencyList(edges);
     //   dfsImpl(adjacencyList);
     //   bfsImpl(adjacencyList);
        dfsRecursiveImpl(adjacencyList,"a");
    }


    private static Map<String, List<String>> buildAdjacencyList(String[][] edges){
        Map<String,List<String>> adjacencyList = new HashMap<>();
        for(String[] edge : edges){
            if(adjacencyList.containsKey(edge[0])){
                adjacencyList.get(edge[0]).add(edge[1]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(edge[1]);
                adjacencyList.put(edge[0],list);
            }
        }
        System.out.println(adjacencyList);
        return adjacencyList;
    }

    private static void dfsImpl(Map<String,List<String>> adjacencyList){
        Deque<String> stack = new ArrayDeque<>();
        stack.add("a");
        while (!stack.isEmpty()){
            String element = stack.removeFirst();
            List<String> neighbors = adjacencyList.get(element);
            if(neighbors!=null && !neighbors.isEmpty()) {
                for (String s : neighbors) {
                    stack.addFirst(s);
                }
            }
            System.out.println(element);
        }
    }

    private static void dfsRecursiveImpl(Map<String,List<String>> adjacencyList,String source){
        System.out.println(source);
        if(adjacencyList.containsKey(source)) {
            for(String neighbor : adjacencyList.get(source)){
                dfsRecursiveImpl(adjacencyList,neighbor);
            }
        }
    }

    private static void bfsImpl(Map<String,List<String>> adjacencyList){
        Deque<String> queue = new ArrayDeque<>();
        queue.add("a");
        while (!queue.isEmpty()) {
            String element = queue.removeLast();
            List<String> neighbors = adjacencyList.get(element);
            if(neighbors!=null && !neighbors.isEmpty()) {
                for (String s : neighbors) {
                    queue.addFirst(s);
                }
            }
            System.out.println(element);
        }
    }


}
