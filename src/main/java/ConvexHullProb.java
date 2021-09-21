
/* day -1 */

/*

https://leetcode.com/problems/erect-the-fence/

You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.

You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter.

Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]

Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]


 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvexHullProb {
    public static void main(String[] args) {

    }


    private Set<Point> findConvexHull(List<Point> points){
        Set<Point> result = new HashSet<Point>();
        if(points == null || points.isEmpty() || points.size() <=3) {
             return new HashSet<Point>(points);
        }

        Point start = points.get(0);

        for(Point point : points){
            if(point.x < start.x){
                start = point;
            }
        }

        Point current = start;
        result.add(start);
        List<Point> coLinear = new ArrayList<Point>();

        while (true) {
            Point nextTarget = points.get(0);
            for(int i=1; i<points.size() ; i++) {
                if(points.get(i)==current){
                    continue;
                }
                int crossProduct = crossProduct(current,nextTarget,points.get(i));
                if(crossProduct > 0) {
                    nextTarget = points.get(i);
                    coLinear = new ArrayList<>();
                }
                else if(crossProduct == 0){
                    if(distance(current,nextTarget, points.get(i)) < 0){
                        coLinear.add(nextTarget);
                        nextTarget = points.get(i);
                    } else {
                        coLinear.add(points.get(i));
                    }
                }
            }

            result.addAll(coLinear);
            if(nextTarget == start){
                break;
            }
            result.add(nextTarget);
            current = nextTarget;
        }
        return result;
    }

    private int crossProduct(Point a, Point b , Point c){
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        return (y2*x1)-(y1*x2);
    }

    private int distance(Point a, Point b , Point c){
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        return Integer.compare(y1*y1+x1*x1,y2*y2+x2*x2);
    }




    class Point {
        int x ;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*public int[][] outerTrees(int[][] trees) {

        if(trees == null || trees.length < 3) {
            return trees;
        }
        int[] leftMost = trees[0];
        for(int[] tree : trees) {
            if(tree[0] < leftMost[0]) {
                leftMost = tree;
            }
        }

        Set<int[]> result = new HashSet<int[]>(trees.length);
        result.add(leftMost);
        for(int[] tree : trees) {
            if(tree == leftMost) {
                continue;
            }
        }


        return null;
    }*/
}
