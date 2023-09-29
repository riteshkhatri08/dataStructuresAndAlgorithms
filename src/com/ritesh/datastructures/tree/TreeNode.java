package com.ritesh.datastructures.tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    TreeNode() {
    }

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.val = value;
    }

    public TreeNode(int value) {

        this.val = value;
    }

}
