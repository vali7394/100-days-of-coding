package com.problemsolving.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversalExamples {

    private void dfsTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        dfsTraversal(node.left);
        dfsTraversal(node.right);
    }

    private void dfsTraversalStack(TreeNode node){
        if(node == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            System.out.println(node.val);
            if(root.left!=null) stack.add(root.left);
            if(root.right!=null) stack.add(root.right);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}




