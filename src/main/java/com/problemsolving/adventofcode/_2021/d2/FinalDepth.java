package com.problemsolving.adventofcode._2021.d2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FinalDepth {

    public static void main(String[] args) {
      //  List<String> input = List.of("forward 5","down 5","forward 8","up 3","down 8","forward 2");
        List<String> input = getDirectionMeasurements();
       // System.out.println(calculateFinalDepth(input));
        System.out.println(calculateFinalDepthPartTwo(input));
    }

    private static long calculateFinalDepthPartTwo(List<String> input){
        int forward=0;
        int depth=0;
        int aim=0;
        for(String s : input){
            String[] tokens = s.split(" ");
            if("forward".equalsIgnoreCase(tokens[0])){
                int measurement = Integer.parseInt(tokens[1]);
                depth += aim*measurement;
                forward+=measurement;
            } else if("down".equalsIgnoreCase(tokens[0])){
                aim+=Integer.parseInt(tokens[1]);
            }else {
                aim-=Integer.parseInt(tokens[1]);
            }
        }
        return forward*depth;
    }

    private static int calculateFinalDepth(List<String> input){
        int forward=0;
        int depth=0;
        for(String s : input){
            String[] tokens = s.split(" ");
            if("forward".equalsIgnoreCase(tokens[0])){
                forward+=Integer.parseInt(tokens[1]);
            } else if("down".equalsIgnoreCase(tokens[0])){
                depth+=Integer.parseInt(tokens[1]);
            }else {
                depth-=Integer.parseInt(tokens[1]);
            }
        }
        return forward*depth;
    }

    private static List<String> getDirectionMeasurements(){
        String fileName = "/Users/vali94/Documents/github-repos/Everyday-Problem-Solving/src/main/java/com/problemsolving/adventofcode/_2021/d2/SubDirections.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.collect(Collectors.toList());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

/*
The submarine seems to already have a planned course (your puzzle input). You should probably figure out where it's going. For example:

forward 5
down 5
forward 8
up 3
down 8
forward 2
Your horizontal position and depth both start at 0. The steps above would then modify them as follows:

forward 5 adds 5 to your horizontal position, a total of 5.
down 5 adds 5 to your depth, resulting in a value of 5.
forward 8 adds 8 to your horizontal position, a total of 13.
up 3 decreases your depth by 3, resulting in a value of 2.
down 8 adds 8 to your depth, resulting in a value of 10.
forward 2 adds 2 to your horizontal position, a total of 15.
After following these instructions, you would have a horizontal position of 15 and a depth of 10. (Multiplying these together produces 150.)

Calculate the horizontal position and depth you would have after following the planned course. What do you get if you multiply your final horizontal position by your final depth?
 */