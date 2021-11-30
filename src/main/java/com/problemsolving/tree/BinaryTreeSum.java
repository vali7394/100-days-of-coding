package com.problemsolving.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class BinaryTreeSum {





    private static int treeSum(TreeNode node){
        if(node==null){
            return 0;
        }
        return node.val + treeSum(node.left)+treeSum(node.right);
    }

    private static int treeMinVal(TreeNode node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        return Math.min(node.val,Math.min(treeMinVal(node.left),treeMinVal(node.right)));
    }

    private static int treeMinValBfs(TreeNode node){
        int result = Integer.MAX_VALUE;
        if(node==null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode root = queue.poll();
            result = Math.min(result,root.val);
            if(root.left!=null) queue.add(root.left);
            if(root.right!=null) queue.add(root.right);
        }
        return result;
    }

    private static int treePathSumBfs(TreeNode node, int sum,Set<Integer> pathSums){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        int result = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            TreeNode root = queue.poll();
            int currentSum=root.sumSoFar+root.val;
            if(root.left==null&&root.right==null){
                result = Math.max(currentSum,result);
            } else {
                if(root.left!=null){
                    TreeNode left = root.left;
                    left.sumSoFar = currentSum;
                    queue.add(left);
                }
                if(root.right!=null){
                    TreeNode right = root.right;
                    right.sumSoFar = currentSum;
                    queue.add(right);
                }
            }
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int sumSoFar;

    }

    private int findMaxSumPath(TreeNode treeNode){
        if(treeNode==null){
            return Integer.MIN_VALUE;
        }
        if(treeNode.left==null&&treeNode.right==null){
            return treeNode.val;
        }
        int maxChildPath = Math.max(findMaxSumPath(treeNode.left),
                findMaxSumPath(treeNode.right));
        return treeNode.val+maxChildPath;
    }
}
