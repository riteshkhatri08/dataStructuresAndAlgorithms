package Lists;

public class DoubleLinkedList {
    DllNode head;
    DllNode tail;

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.add(3);
        list.add(5);
        list.add(7);
        list.addToFront(1);
        list.addAfter(1, 2);
        list.addAfter(3, 4);
        list.addAfter(5, 6);
        list.addAfter(7, 8);
        list.delete(3);
        list.printForward();
        // list.printBackward();

    }

    private void delete(int value) {

        DllNode nodeToDelete = this.head;

        while (nodeToDelete != null && nodeToDelete.value != value) {
            // Search the node which we want to delete
            nodeToDelete = nodeToDelete.next;
        }

        if (this.head == this.tail) {
            // Only single node is present
            this.head = this.tail = null;
        } else if (this.head == nodeToDelete) {
            // **** NODE Found at Head
            // Set head to point to the next element
            this.head = this.head.next;
            // make sure the new head's prev doesn't point to the node which is to be
            // deleted
            this.head.prev = null;

        } else if (this.tail == nodeToDelete) {
            // **** NODE Found at Last
            // Set tail to point to the second last element.
            this.tail = this.tail.prev;
            // make sure second last element doesnt point the node which is to be deleted
            this.tail.next = null;

        } else {
            // Make sure the node.prev for node after the node (which is to be deleted)
            // points to the node before the node (which is to be delete)
            nodeToDelete.next.prev = nodeToDelete.prev;
            // Make sure the node.next for node before the node (which is to be deleted)
            // points to the node after the node (which is to be delete)
            nodeToDelete.prev.next = nodeToDelete.next;

        }
        // Leave this for GC to collect
        nodeToDelete = null;
    }

    private void addAfter(int valueToSearch, int newValue) {

        DllNode newNode = new DllNode(newValue);
        DllNode nodeToAddAfter = this.head;

        while (nodeToAddAfter != null && nodeToAddAfter.value != valueToSearch) {
            nodeToAddAfter = nodeToAddAfter.next;
        }

        // Value not found or List is empty so nodeToAddAfter is null
        if (nodeToAddAfter == null) {

            System.out.println("\nValue \'" + valueToSearch + "\' not found or List might be empty.. Cannot insert");

        } else if (this.tail == nodeToAddAfter) {

            // Value found at tail so we just add to back
            this.add(newValue);

        } else {

            // Value is somwhere in the middle or at the head so we add new node after it.
            newNode.prev = nodeToAddAfter;
            newNode.next = nodeToAddAfter.next;
            nodeToAddAfter.next.prev = newNode;
            nodeToAddAfter.next = newNode;

        }

    }

    private void addToFront(int value) {
        DllNode newNode = new DllNode(value);

        // Enter if block when nodes are already present in DLL
        if (this.head != null) {
            // Set current head's prev to newNode because new node is added before current
            // head
            this.head.prev = newNode;

            // Set new node's next to point to current head because new node is added at
            // front i.e. before current head
            newNode.next = this.head;

            // set the head to point to new Node because new Node is now at front
            this.head = newNode;

        } else {

            // Set tail to point to new node becasue this is the first time we are adding a
            // node to front
            this.tail = newNode;
        }

        // Set the head to the new node
        this.head = newNode;

    }

    private void add(int value) {

        DllNode newNode = new DllNode(value);

        // Enter if block when nodes are already present in DLL
        if (this.head != null) {
            // Set current tail's next to new node because newNode is added at the back
            this.tail.next = newNode;

            // Set newNode's prev to point to current tail because this is added at back
            newNode.prev = this.tail;

        } else {

            // Set head to new node because this is the first time a node is added
            this.head = newNode;
        }
        // Set the new tail because newNode should be at end
        this.tail = newNode;
    }

    private void printForward() {
        // Check if any elements are present or not
        if (this.head == null) {

            System.out.println("No Elements ");

        } else {

            // Set curNode to head because we'll start printing from front
            DllNode curNode = this.head;

            System.out.println("\nElements forward are -");

            while (curNode != null) {
                System.out.print(curNode.value + " ");
                // Move to the next node after curNode
                curNode = curNode.next;
            }
        }
    }

    private void printBackward() {

        // Check if any elements are present or not
        if (this.tail == null) {
            System.out.println("No Elements ");

        } else {

            // Set curNode to tail because we'll start printing from back
            DllNode curNode = this.tail;

            System.out.println("\nElements backward are -");
            while (curNode != null) {
                System.out.print(curNode.value + " ");
                // Tell curNode to point to the Node before curNode
                curNode = curNode.prev;
            }
        }
    }
}
