package com.ritesh.datastructures.list;

public class CircularSentinelList {

    SentinelNode head;

    public CircularSentinelList() {

        this.head = new SentinelNode(null);
        this.head.next = this.head.prev = this.head;

    }

    public static void main(String[] args) {
        CircularSentinelList list = new CircularSentinelList();
        list.addToBack(3);
    }

    private void addToBack(int value) {
    }

}