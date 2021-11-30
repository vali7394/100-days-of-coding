package com.problemsolving.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValueInBinaryTree {

    private boolean findValueInBT(TreeNode node,int key){
        if(node==null){
            return false;
        }
        if(node.val==key){
            return true;
        }
        return findValueInBT(node.left,key) || findValueInBT(node.right,key);
    }

    private boolean findKeyInBTWithBFS(TreeNode node,int key){
        if(node==null){
            return false;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode root = queue.poll();
            if(root.val==key){
                return true;
            }
            if(root.left!=null) queue.add(root.left);
            if(root.right!=null) queue.add(root.right);
        }
        return false;
    }
}
