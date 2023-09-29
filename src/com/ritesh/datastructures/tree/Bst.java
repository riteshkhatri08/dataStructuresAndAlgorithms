package com.ritesh.datastructures.tree;

import java.util.ArrayList;
import java.util.stream.Stream;

class Node {

    Node right;
    Node left;
    int value;

    public Node(int value) {
        this.value = value;
    }

}

public class Bst {

    Node root;
    ArrayList<Node> leafNodes;

    public Bst() {

        leafNodes = new ArrayList<>();
        leafNodes.add(root);

    }

    public static void main(String[] args) {
        var tree = new Bst();

        tree.add(100);
        tree.add(50);
        tree.add(200);
        tree.add(150);
        tree.add(300);
        tree.add(125);
        tree.add(156);
        tree.add(125);
        tree.add(120);
        tree.add(130);
        tree.add(122);
        tree.add(60);
        tree.add(65);
        tree.add(30);
        tree.delete(100);
        // tree.printInOrder();
        // tree.printPreOrder();
        // tree.printPostOrder();

    }

    private void add(int value) {
        // Wrapper function -add() which calls the recursive function addNode()
        this.root = this.addNode(this.root, value);
        System.out.println("Added " + value);
    }

    private Node addNode(Node current, int value) {

        return null != current
                ? value > current.value ? (current.right = this.addNode(current.right, value)) != null ? current : null
                        : (current.left = this.addNode(current.left, value)) != null ? current : null
                : new Node(value);
    }

    private void delete(int value) {
        // Wrapper function for delete
        this.root = this.deleteNode(this.root, value);
    }

    private Node deleteNode(Node current, int value) {
        if (null == current) {
            return null;
        } else if (value > current.value) {
            current.right = this.deleteNode(current.right, value);
        } else if (value < current.value) {
            current.left = this.deleteNode(current.left, value);
        } else {
            // Case 1- No child
            if (null == current.right && null == current.left) {
                return null;
            }

            // Case 2 - when there's right child only
            else if (null != current.right && null == current.left) {
                return current.right;
            }

            // Case 3 - when there's left child only
            else if (null == current.right && null != current.left) {
                return current.left;
            }

            else {

                // Case 4 - when both children are present
                // Find either a succesor or predecessor
                // Predecessor - Right most node of left subtree
                // Successor - Left most node of right subtree

                current = current.right;

                while (current.left != null) {
                    current = current.left;
                }
                System.out.println(current.value);
            }

        }
        return current;

    }

    private void printInOrder() {
        System.out.println("\nTree in order is  - \n");
        // Wrapper function for printing
        this.printSubTreeInOrder(this.root, 0);
    }

    private void printSubTreeInOrder(Node current, int spaces) {

        if (null != current) {
            // In Order
            spaces += 1;
            this.printSubTreeInOrder(current.left, spaces);
            Stream.generate(() -> " _ _ _ ").limit(spaces).forEach(System.out::print);
            System.out.print(current.value + " ");
            System.out.println("");
            this.printSubTreeInOrder(current.right, spaces);
        }
    }

    private void printPreOrder() {
        System.out.println("\nTree in pre order is - ");
        // Wrapper function for printing
        this.printSubTreePreOrder(this.root);
    }

    private void printSubTreePreOrder(Node current) {

        if (null != current) {
            // In Order
            System.out.print(current.value + " ");
            this.printSubTreePreOrder(current.left);
            this.printSubTreePreOrder(current.right);
        }
    }

    private void printPostOrder() {
        System.out.println("\nTree in post order is - ");
        // Wrapper function for printing
        this.printSubTreePostOrder(this.root);
    }

    private void printSubTreePostOrder(Node current) {

        if (null != current) {
            // In Order
            this.printSubTreePostOrder(current.left);
            this.printSubTreePostOrder(current.right);
            System.out.print(current.value + " ");
        }
    }
}
