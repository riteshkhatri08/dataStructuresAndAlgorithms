package com.ritesh.datastructures.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public TreeNode rootNode;

    public BinaryTree() {

    }

    public BinaryTree(int value) {
        this.rootNode = new TreeNode(value);
    }

    public void addNode(int i) {
        TreeNode newNode = new TreeNode(i);
        // find the empty node
        TreeNode currentNode = this.rootNode;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(currentNode);
        while (null != nodeQueue.peek()) {

            currentNode = nodeQueue.poll();

            if (null != currentNode.left) {
                nodeQueue.add(currentNode.left);
                // System.out.print(currentNode.left.value);
            } else {
                currentNode.left = newNode;
                break;
            }

            if (null != currentNode.right) {
                nodeQueue.add(currentNode.right);
                // System.out.print(currentNode.right.value);

            } else {
                currentNode.right = newNode;
                break;
            }
        }
        // System.out.println();
    }

    public void inOrder(TreeNode node) {

        // if (node.left == null) {
        // // System.out.println(node.value);
        // return;
        // }
        // if (node.right == null) {
        // // System.out.println(node.value);
        // return;
        // }

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");

        inOrder(node.right);

    }

    public void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);

    }

    public void postOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");

    }

    // private void constructInOrderTreeWrapper(int left, int right, int[] arr) {

    // int middle = (right - left) / 2;

    // System.out.println(middle);
    // Node leftNode = constructInOrderTree(0, middle, arr);
    // this.rootNode = new Node(arr[middle]);
    // rootNode.left = leftNode;
    // rootNode.right = constructInOrderTree(middle + 1, right, arr);

    // }

    // private Node constructInOrderTree(int left, int right, int[] arr) {

    // int middle = (right - left) / 2;

    // return null;
    // }
    private TreeNode constructNewTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inordermap = new HashMap<Integer, Integer>();
        ArrayList<Integer> preorderList =  new ArrayList<Integer>();
        for (int index = inorder.length - 1; index >= 0; index--) {
            inordermap.put(inorder[index], index);
            preorderList.add(preorder[index]);

        }
        
       

        return constructNewTreeHelper(0, preorder.length, inordermap, preorderList);
    }

    private TreeNode constructNewTreeHelper(int left, int right, HashMap<Integer, Integer> inordermap,
    ArrayList<Integer> preorderList) {
                // System.out.println(left + " " + right + " " + preordercount + " " + preorder[preordercount])  ;
        if (left >= right) {
            return null;
        }

        TreeNode newNode = new TreeNode(preorderList.remove(preorderList.size()-1));
        int middle = inordermap.get(newNode.val);
        // preordercount++;
        newNode.left = constructNewTreeHelper(left, middle, inordermap, preorderList);
        // System.out.println("going right");
        newNode.right = constructNewTreeHelper(middle + 1, right, inordermap, preorderList);

        return newNode;
    }

    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree(1);
        // tree.addNode(2);
        // tree.addNode(3);
        // tree.addNode(4);
        // tree.addNode(5);
        // tree.addNode(6);
        // tree.addNode(7);
        // tree.addNode(8);
        // tree.addNode(9);
        // tree.addNode(10);
        // tree.addNode(11);
        // System.out.println("\nPREORDER ");
        // tree.preOrder(tree.rootNode);
        // System.out.println("\nIN ORDER");
        // tree.inOrder(tree.rootNode);
        // tree.postOrder(tree.rootNode);
        // BinaryTree newTree = new BinaryTree();

        // newTree.constructInOrderTreeWrapper(0, arr.length, arr);
        // newTree.preOrder(newTree.rootNode);

        Deque<Integer> preOrder = new ArrayDeque<Integer>(Arrays.asList(1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 7));
        ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(8, 4, 9, 2, 10, 5, 11, 1, 6, 3, 7));
        BinaryTree newTree = new BinaryTree();
        // newTree.rootNode = newTree.constructNewTree(preOrder, inOrder);

        // System.out.println();
        // newTree.inOrder(newTree.rootNode);
        // System.out.println();
        // newTree.preOrder(newTree.rootNode);
        // System.out.println();
        // newTree.postOrder(newTree.rootNode);

        int[] inorder = new int[] { 8, 4, 9, 2, 10, 5, 11, 1, 6, 3, 7 };
        int[] preorder = new int[] { 1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 7 };
        BinaryTree fasterTree = new BinaryTree();
        fasterTree.rootNode = fasterTree.constructNewTree(preorder, inorder);

        System.out.println();
        fasterTree.inOrder(fasterTree.rootNode);
        // System.out.println();
        // newTree.preOrder(newTree.rootNode);
        // System.out.println();
        // newTree.postOrder(newTree.rootNode);

    }

}
