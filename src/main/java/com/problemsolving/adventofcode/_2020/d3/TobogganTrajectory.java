package com.problemsolving.adventofcode._2020.d3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TobogganTrajectory {
   /* public static void main(String[] args) {
//        char[][] input = new char[][]{
//                {'.','.','#','#','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','.'},
//                {'#','.','.','O','#','.','.','.','#','.','.','#','.','.','.','#','.','.','.','#','.','.','#','.','.','.','#','.','.','.','#','.','.','#','.','.','.','#','.','.','.','#','.','.','#','.','.','.','#','.','.','.','#','.','.','#','.','.','.','#','.','.','.','#','.','.'},
//                {'.','#','.','.','.','.','X','.','.','#','.','.','#','.','.','.','.','#','.','.','#','.','.','#','.','.','.','.','#','.','.','#','.','.','#','.','.','.','.','#','.','.','#','.','.','#','.','.','.','.','#','.','.','#','.','.','#','.','.','.','.','#','.','.','#','.'},
//                {'.','.','#','.','#','.','.','.','#','O','#','.','.','#','.','#','.','.','.','#','.','#','.','.','#','.','#','.','.','.','#','.','#','.','.','#','.','#','.','.','.','#','.','#','.','.','#','.','#','.','.','.','#','.','#','.','.','#','.','#','.','.','.','#','.','#'},
//                {'.','#','.','.','.','#','#','.','.','#','.','.','X','.','.','.','#','#','.','.','#','.','.','#','.','.','.','#','#','.','.','#','.','.','#','.','.','.','#','#','.','.','#','.','.','#','.','.','.','#','#','.','.','#','.','.','#','.','.','.','#','#','.','.','#','.'},
//                {'.','.','#','.','#','#','.','.','.','.','.','.','.','#','.','X','#','.','.','.','.','.','.','.','#','.','#','#','.','.','.','.','.','.','.','#','.','#','#','.','.','.','.','.','.','.','#','.','#','#','.','.','.','.','.','.','.','#','.','#','#','.','.','.','.','.'},
//                {'.','#','.','#','.','#','.','.','.','.','#','.','#','.','#','.','#','.','O','.','.','#','.','#','.','#','.','#','.','.','.','.','#','.','#','.','#','.','#','.','.','.','.','#','.','#','.','#','.','#','.','.','.','.','#','.','#','.','#','.','#','.','.','.','.','#'},
//                {'.','#','.','.','.','.','.','.','.','.','#','.','#','.','.','.','.','.','.','.','.','X','.','#','.','.','.','.','.','.','.','.','#','.','#','.','.','.','.','.','.','.','.','#','.','#','.','.','.','.','.','.','.','.','#','.','#','.','.','.','.','.','.','.','.','#'},
//                {'#','.','#','#','.','.','.','#','.','.','.','#','.','#','#','.','.','.','#','.','.','.','#','.','X','#','.','.','.','#','.','.','.','#','.','#','#','.','.','.','#','.','.','.','#','.','#','#','.','.','.','#','.','.','.','#','.','#','#','.','.','.','#','.','.','.'},
//                {'#','.','.','.','#','#','.','.','.','.','#','#','.','.','.','#','#','.','.','.','.','#','#','.','.','.','#','X','.','.','.','.','#','#','.','.','.','#','#','.','.','.','.','#','#','.','.','.','#','#','.','.','.','.','#','#','.','.','.','#','#','.','.','.','.','#'},
//                {'.','#','.','.','#','.','.','.','#','.','#','.','#','.','.','#','.','.','.','#','.','#','.','#','.','.','#','.','.','.','X','.','#','.','#','.','.','#','.','.','.','#','.','#','.','#','.','.','#','.','.','.','#','.','#','.','#','.','.','#','.','.','.','#','.','#'}
//        };
       // System.out.println(calculateTreeCount(input,1,3));
        String filePath = "/Users/vali94/Documents/github-repos/Everyday-Problem-Solving/src/main/java/com/problemsolving/adventofcode/_2020/d3/infinteForest.txt";
        long result = calculateTreeCount(filePath,1,1)*calculateTreeCount(filePath,1,3)*
                calculateTreeCount(filePath,1,5)*
                calculateTreeCount(filePath,1,7)*
                calculateTreeCount(filePath,2,1);
       // System.out.println(result);
    } */
    private static int calculateTreeCount(String fileName,int rowStart, int colStart){
        int treeCount = 0;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> streamInput = stream.collect(Collectors.toList());
            String[][] input = new String[streamInput.size()][streamInput.get(0).split("").length];
            int i=0;
            for(String line : streamInput){
                input[i] = line.split("");
               i++;
            }
            while (rowStart<input.length){
                if(input[rowStart][colStart].equalsIgnoreCase("#")){
                    treeCount++;
                }
                rowStart+=1;
                if(colStart+3>=input[0].length){
                    colStart=(colStart+3)%input[0].length;
                }else {
                    colStart+=3;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return treeCount;
    }
    static String filePath = "/Users/vali94/Documents/github-repos/Everyday-Problem-Solving/src/main/java/com/problemsolving/adventofcode/_2020/d3/infinteForest.txt";

    public static void main(String[] args) throws IOException {
        int rows = getRows();
        int columns = getCols();

        char[][] map = popMap(rows, columns);

        System.out.println("\n The number of trees hit in pt.1: " + traverse(map, rows, columns, 3, 1));
        System.out.println("\n The solution to pt.2: " + partTwo(map, rows, columns));
    }

    private static int getRows() throws IOException {
        BufferedReader br_size = new BufferedReader(new FileReader(filePath));
        int rows = 0;
        while (br_size.readLine() != null) rows++;
        br_size.close();
        return rows;
    }

    private static int getCols() throws FileNotFoundException {
        Scanner s = new Scanner(new File(filePath));
        int columns = 0;
        columns = s.next().length();
        s.close();
        return columns;
    }

    private static char[][] popMap(int rows, int cols) throws FileNotFoundException{
        char[][] map = new char[rows][cols];
        Scanner s = new Scanner(new File(filePath));

        int row_count = 0;
        String str = "";
        while (s.hasNextLine()) {
            str = s.nextLine();
            for (int i = 0; i < cols; i++) {
                map[row_count][i] = str.charAt(i);
            }
            row_count++;
        }
        s.close();
        return map;
    }

    private static int partTwo(char[][] map, int rows, int cols) {
        int sol = 0;
        sol = traverse(map, rows, cols, 1, 1)*traverse(map, rows, cols, 3, 1)*traverse(map, rows, cols, 5, 1)*traverse(map, rows, cols, 7, 1)*traverse(map, rows, cols, 1, 2);
        return sol;
    }
    private static int traverse(char[][] map, int rows, int cols, int right, int down) {
        int trees = 0;
        int cur_row = 0;
        int cur_col = 0;

        while (cur_row < rows) {

            if (map[cur_row][cur_col] == '#')
                trees++;

            cur_row += down;
            if ((cur_col+right) >= cols)
                cur_col = ((cur_col+right) % cols);
            else
                cur_col += right;
        }
        return trees;
    }

    // For validating input
    private static void printInput(char[][] map, int rows, int cols) {
        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}


/*
--- Day 3: Toboggan Trajectory ---
With the toboggan login problems resolved, you set off toward the airport. While travel by toboggan might be easy, it's certainly not safe: there's very minimal steering and the area is covered in trees. You'll need to see which angles will take you near the fewest trees.

Due to the local geology, trees in this area only grow on exact integer coordinates in a grid. You make a map (your puzzle input) of the open squares (.) and trees (#) you can see. For example:

..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
These aren't the only trees, though; due to something you read about once involving arboreal genetics and biome stability, the same pattern repeats to the right many times:

..##.........##.........##.........##.........##.........##.......  --->
#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
.#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
.#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....  --->
.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
.#........#.#........#.#........#.#........#.#........#.#........#
#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
#...##....##...##....##...##....##...##....##...##....##...##....#
.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
You start on the open square (.) in the top-left corner and need to reach the bottom (below the bottom-most row on your map).

The toboggan can only follow a few specific slopes (you opted for a cheaper model that prefers rational numbers); start by counting all the trees you would encounter for the slope right 3, down 1:

From your starting position at the top-left, check the position that is right 3 and down 1. Then, check the position that is right 3 and down 1 from there, and so on until you go past the bottom of the map.

The locations you'd check in the above example are marked here with O where there was an open square and X where there was a tree:

..##.........##.........##.........##.........##.........##.......  --->
#..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
.#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
.#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##.....  --->
.#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
.#........#.#........X.#........#.#........#.#........#.#........#
#.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
#...##....##...##....##...#X....##...##....##...##....##...##....#
.#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
In this example, traversing the map using this slope would cause you to encounter 7 trees.

Starting at the top-left corner of your map and following a slope of right 3 and down 1, how many trees would you encounter?
 */