package com.problemsolving.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {

    }

    private int buildBinaryTree(Node node,int low,int high){
        return binaryTreeSumUtil(node,low,high);
    }

    private int binaryTreeSumUtil(Node node,int low,int high){
        if(node==null){
            return 0;
        }
        if(low<=node.getValue() && node.getValue()<=high){
            return node.getValue();
        }
        int sum = 0;
        sum+=binaryTreeSumUtil(node.left,low,high);
        sum+=binaryTreeSumUtil(node.right,low,high);
        return sum;
    }

    private int binaryTreeSumUtilStack(Node node,int low,int high){
        if(node==null){
            return 0;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.addFirst(node);
        int sum=0;
        while (!stack.isEmpty()){
            Node root = stack.removeFirst();
            if(low<=root.getValue() && root.getValue()>=high){
                sum+=root.getValue();
            }
            if(root.getLeft()!=null){
                stack.addFirst(root.getLeft());
            }
            if(root.getRight()!=null){
                stack.addFirst(root.getRight());
            }
        }
        return sum;
    }


}


class Node {
    private int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }
}