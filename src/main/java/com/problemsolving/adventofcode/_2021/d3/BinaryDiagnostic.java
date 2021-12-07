package com.problemsolving.adventofcode._2021.d3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryDiagnostic {

    public static void main(String[] args) {
      //  List<String> input = List.of("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010");
        List<String> input = readBinaryReadingsFromFile("/Users/vali94/Documents/github-repos/Everyday-Problem-Solving/src/main/java/com/problemsolving/adventofcode/_2021/d3/binary-readings.txt");
        System.out.println(getConsumptionReportPartTwo(input));
    }

    private static int getConsumptionReport(List<String> binaryCodings) {
        Map<Integer, Map<String, Integer>> bitTracker = new HashMap<>();
        for (String code : binaryCodings) {
            String[] tokens = code.split("");
            for (int i = 0; i < tokens.length; i++) {
                Map<String, Integer> counter = bitTracker.getOrDefault(i, new HashMap<>());
                counter.put(tokens[i], counter.getOrDefault(tokens[i], 0) + 1);
                bitTracker.put(i, counter);
            }
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < binaryCodings.get(0).length(); i++) {
            Map<String, Integer> bitCounter = bitTracker.get(i);
            int zeroCount = bitCounter.getOrDefault("0", 0);
            int oneCount = bitCounter.getOrDefault("1", 0);
            if (oneCount > zeroCount) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        return Integer.parseInt(gamma.toString(),2)*Integer.parseInt(epsilon.toString(),2);
    }

    private static int getConsumptionReportPartTwo(List<String> binaryCodings) {
        int positionTracker=0;
        List<String> oxygenRatings = new ArrayList<>(binaryCodings);
        List<String> co2Ratings = new ArrayList<>(binaryCodings);
        while (positionTracker<binaryCodings.get(0).length() && (oxygenRatings.size()>1 || co2Ratings.size()>1)){
            Map<Character,List<String>> oxyCounter = new HashMap<>();
            Map<Character,List<String>> co2Counter = new HashMap<>();
            for(int i=0;i<oxygenRatings.size();i++){
                Character binaryDigit = oxygenRatings.get(i).charAt(positionTracker);
                List<String> binaryCodes = oxyCounter.getOrDefault(binaryDigit,new ArrayList<>());
                binaryCodes.add(oxygenRatings.get(i));
                oxyCounter.put(binaryDigit,binaryCodes);
            }
            for(int i=0;i<co2Ratings.size();i++){
                Character binaryDigit = co2Ratings.get(i).charAt(positionTracker);
                List<String> binaryCodes = co2Counter.getOrDefault(binaryDigit,new ArrayList<>());
                binaryCodes.add(co2Ratings.get(i));
                co2Counter.put(binaryDigit,binaryCodes);
            }
               if(oxygenRatings.size()>1){
                   List<String> oneRatings = oxyCounter.getOrDefault('1',List.of());
                   List<String> zeroRatings = oxyCounter.getOrDefault('0',List.of());
                   oxygenRatings = oneRatings.size() >= zeroRatings.size() ? oneRatings : zeroRatings;
               }
            if(co2Ratings.size()>1){
                List<String> oneRatings = co2Counter.getOrDefault('1',List.of());
                List<String> zeroRatings = co2Counter.getOrDefault('0',List.of());
                co2Ratings = zeroRatings.size() <= oneRatings.size() ? zeroRatings : oneRatings;
            }
            positionTracker++;
        }
        return Integer.parseInt(oxygenRatings.get(0),2)*Integer.parseInt(co2Ratings.get(0),2);
    }

    private static List<String> readBinaryReadingsFromFile(String fileName){
        try(Stream<String> lines = Files.lines(Path.of(fileName))){
            return lines.collect(Collectors.toList());
        }catch (IOException e){
           e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

/*
You need to use the binary numbers in the diagnostic report to generate two new binary numbers (called the gamma rate and the epsilon rate). The power consumption can then be found by multiplying the gamma rate by the epsilon rate.

Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report. For example, given the following diagnostic report:

00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010
Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.

The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.

The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.

So, the gamma rate is the binary number 10110, or 22 in decimal.

The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used. So, the epsilon rate is 01001, or 9 in decimal. Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.

Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
 */