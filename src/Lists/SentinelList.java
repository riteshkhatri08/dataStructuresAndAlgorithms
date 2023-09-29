package Lists;

import java.util.*;

public class SentinelList {

    SentinelNode head;
    SentinelNode tail;

    public SentinelList() {
        this.head = new SentinelNode(null);
        this.tail = new SentinelNode(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public static void main(String[] args) {
        SentinelList sl = new SentinelList();

        sl.addToBack(4, 5, 6);
        sl.addToFront(3, 2, 1);
        sl.addToBack(10);
        sl.addBefore(10, 7, 8, 9);
        sl.delete(1, 3, 5, 7, 9, 11,22,3);
        sl.print();
    }

    private void addBefore(int valueOfNodeToAddBefore, int... newValues) {
        // start searching with head.next
        SentinelNode nodeToAddBefore = this.head.next;

        boolean nodeFoundFlag = false;
        while (nodeToAddBefore != this.tail) {

            if (valueOfNodeToAddBefore == nodeToAddBefore.value.intValue()) {
                nodeFoundFlag = true;
                break;
            }

            nodeToAddBefore = nodeToAddBefore.next;

        }

        if (false == nodeFoundFlag) {
            System.out.println("Cannot perform add : Value to add before not found or List may be empty");
            return;
        }

        for (int newValue : newValues) {

            SentinelNode newNode = new SentinelNode(Integer.valueOf(newValue));
            this.commonInsert(nodeToAddBefore, newNode);
            System.out.println("New node with value [" + newValue + "] was added before a node having value ["
                    + valueOfNodeToAddBefore + "].");
        }

    }

    private void commonInsert(SentinelNode nodeToAddBefore, SentinelNode newNode) {
        // Common insert code called by other nodes

        // Put right hand on nodeToAddBefore
        newNode.next = nodeToAddBefore;

        // Put left hand on node just before nodeToAddBefore
        newNode.prev = nodeToAddBefore.prev;

        // Put left partner's right hand on new node
        newNode.prev.next = newNode;

        // Put newNode's right partner's (nodeToAddBefore) left hand on newNode
        newNode.next.prev = newNode;

    }

    private void delete(int... valuesToDelete) {

        SentinelNode curNode = this.head.next;

        ArrayList<Integer> deleteList = new ArrayList<Integer>();
        for (int value : valuesToDelete) {
            deleteList.add(value);
        }

        while (curNode != this.tail) {
            int curNodeValue = curNode.value.intValue();

            if (true == deleteList.contains(curNodeValue)) {

                deleteList.remove(Integer.valueOf(curNodeValue));

                curNode.next.prev = curNode.prev;
                curNode.prev.next = curNode.next;

                System.out.println("Node with value " + curNodeValue + " was deleted");

            }

            curNode = curNode.next;
        }

        if (!deleteList.isEmpty()) {
            String remainingValues = "";
            for (int value : deleteList) {
                remainingValues += value + ", ";
            }
            System.out.println("Cannot delete the value(s) [ " + remainingValues + "\b\b ] : Not found in list");
        }

    }

    private void addToFront(int... values) {

        for (int value : values) {

            SentinelNode newNode = new SentinelNode(Integer.valueOf(value));
            SentinelNode nodeToAddBefore = this.head.next;

            this.commonInsert(nodeToAddBefore, newNode);

            System.out.println("New Node added to front with value [" + value + "].");
        }
    }

    private void addToBack(int... values) {
        for (int value : values) {

            SentinelNode newNode = new SentinelNode(Integer.valueOf(value));
            SentinelNode nodeToAddBefore = this.tail;

            this.commonInsert(nodeToAddBefore, newNode);

            System.out.println("New Node added to back with value [" + value + "].");
        }
    }

    private void print() {
        // start with this.head.next because this.head is sentinel(non-data node)
        SentinelNode current = this.head.next;
        if (this.head.next == this.tail) {
            System.out.println("\nNo elements in list");
            // escape out because list is empty
            return;
        }
        System.out.print("\nList elements are [ ");
        while (current != this.head && current != this.tail) {
            System.out.print(current.value.toString() + ", ");
            current = current.next;

        }
        System.out.print("\b\b ]\n\n");

    }

}
