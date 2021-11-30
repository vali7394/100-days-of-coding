package com.problemsolving.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ValidateBst {
    public static void main(String[] args) {

    }


    private static boolean bstValidationUtil(TreeNode node){
        if(node==null || (node.left==null && node.right==null)){
            return true;
        }
        if(bstValidationUtil(node.left) && bstValidationUtil(node.right)){
            if(node.left!=null && node.right!=null){
                return node.left.val<node.val && node.right.val>node.val;
            }
            if(node.left!=null){
                return node.left.val<node.val;
            }

            if(node.right!=null){
                return node.right.val>node.val;
            }
        }
        return false;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
