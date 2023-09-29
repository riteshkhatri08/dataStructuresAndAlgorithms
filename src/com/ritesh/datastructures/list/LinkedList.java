package com.ritesh.datastructures.list;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addToEnd(1);
        linkedList.addAfter(1, 4);
        linkedList.addAfter(1, 2);
        linkedList.addAfter(2, 3);
        linkedList.addAfter(4, 6);
        linkedList.addBefore(1, -1);
        linkedList.addBefore(1, 0);
        linkedList.addBefore(6, 5);
        linkedList.delete(3);
        // linkedList.delete(1);
        linkedList.print();
    }

    private void deleteAlternate(int start, int stop, int jumpValue) {
        if (start > stop || stop > this.length || jumpValue < 1 || start < 1 || stop < 1) {
            System.out.println("Invalid input values");
            return;
        }

        Node startNode = this.head;

        for (int i = 1; i < start; i++) {
            startNode = startNode.next;
        }
        Node delNode = startNode;
        int counter = start;
        for (int i = start; i < stop; i += jumpValue) {
            Node back = null;

            for (int j = 0; j < jumpValue; j++) {
                back = delNode;
                delNode = delNode.next;
                counter++;
            }

            //if (counter)
        }

    }

    private void delete(int valueToDelete) {

        Node nodeToDelete = this.head;
        Node nodeBeforeNodeToDelete = nodeToDelete;

        while (nodeToDelete != null && nodeToDelete.value != valueToDelete) {
            // Look for the nodeToDelete... Also keeping track of node before the node which
            // is to be deleted
            nodeBeforeNodeToDelete = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
        }

        // If value to be deleted is not found or List is empty
        if (nodeToDelete == null) {

            System.out.println("Nothing to delete -  List is empty or value not present in list");
            return;
        }
        // If nodeToDelete is found at head
        if (nodeToDelete == this.head) {
            // Just save your head
            this.head = this.head.next;

            // if nodeToDelete is found at tail
        } else if (nodeToDelete == this.tail) {
            // Save your tail first
            this.tail = nodeBeforeNodeToDelete;
            // Make the new tail.next to null because it's a tail !!
            this.tail.next = null;
        } else {

            // Node is in the middle somewhere
            // Just tell the node before the nodeToDelete to point to node after the
            // nodeToDelete
            nodeBeforeNodeToDelete.next = nodeToDelete.next;
        }
        this.length--;
    }

    private void addBefore(int valueToAddBefore, int newValue) {

        Node newNode = new Node(newValue);
        Node nodeToAddBefore = this.head;
        // We start for both at this.head
        Node nodeBeforeNodeToAddBefore = nodeToAddBefore;

        while (nodeToAddBefore != null && nodeToAddBefore.value != valueToAddBefore) {
            nodeBeforeNodeToAddBefore = nodeToAddBefore;
            nodeToAddBefore = nodeToAddBefore.next;
        }

        // Value not found or List is empty so nodeToAddBefore is null
        if (null == nodeToAddBefore) {
            System.out.println("\nValue \'" + valueToAddBefore + "\' not found.. Cannot insert");
            return;
            // If node Before which we want to add is at head
        } else if (this.head == nodeToAddBefore) {

            newNode.next = nodeToAddBefore;
            // Set the new head
            this.head = newNode;

        } else {

            newNode.next = nodeToAddBefore;
            // We tell the node that comes before the node before which we want to add to
            // point it '.next' to newNode
            nodeBeforeNodeToAddBefore.next = newNode;
        }
        this.length++;
    }

    private void addAfter(int valueToAddAfter, int newValue) {
        Node newNode = new Node(newValue);
        Node nodeToAddAfter = this.head;

        while (nodeToAddAfter != null && nodeToAddAfter.value != valueToAddAfter) {
            nodeToAddAfter = nodeToAddAfter.next;
        }

        // Value not found or List is empty so nodeToAddAfter is null
        if (null == nodeToAddAfter) {

            System.out.println("\nValue \'" + valueToAddAfter + "\' not found.. Cannot insert");
            return;

        } else if (this.tail == nodeToAddAfter) {
            // Value found at tail so we just add to back
            this.addToEnd(newValue);
            return;
        } else {
            newNode.next = nodeToAddAfter.next;
            nodeToAddAfter.next = newNode;
        }
        this.length++;
    }

    private void addToEnd(int value) {
        // Create a new node
        Node newNode = new Node(value);

        if (this.head == null) {

            this.head = newNode;

        } else {
            // Add the new node after the last node by telling the current last node there
            // one more node i.e "newNode"
            this.tail.next = newNode;
        }
        // Set tail to point to the new node
        this.tail = newNode;
        this.length++;
        System.out.println("Element Added to End - " + value);
    }

    private void addToFront(int value) {

        // Create a new node
        Node newNode = new Node(value);

        if (this.head == null) {
            this.tail = newNode;

        } else {

            // Add the new Node before the first Node by telling the "newNode" that there's
            // node after it i.e "this.head"
            newNode.next = this.head;

        }

        // Now tell head to point to newNode because it is now at the front.
        this.head = newNode;
        this.length++;
        System.out.println("Element Added to Front - " + value);

    }

    private void print() {

        if (this.head == null) {
            System.out.println("No elements in List");

        } else {

            Node curNode = this.head;
            System.out.println("Elements are :-");
            while (curNode != null) {
                System.out.print(curNode.value + " ");
                curNode = curNode.next;
            }
            System.out.println("");

        }
    }

}
