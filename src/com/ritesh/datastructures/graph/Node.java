package com.ritesh.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    boolean visited;
    int value;
    List<Node> friendList;

    public Node(int value) {
        this.value = value;
    }

    public void addFriends(Node... newFriends) {
        if (null == friendList) {
            friendList = new ArrayList<Node>();
        }
        friendList.addAll(Arrays.asList(newFriends));
    }
}
