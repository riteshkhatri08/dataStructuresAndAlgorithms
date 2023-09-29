package com.ritesh.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Graph {

    HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();

    public Graph(int size) {

        Random r = new Random(System.nanoTime());

        for (int i = 1; i <= size; i++) {

            var friends = new HashSet<Integer>();
            // max 3 friends
            int noOfFriends = 3;
            // while ((noOfFriends = r.nextInt(4)) <= 2)
            // ;

            for (int j = 1; j < noOfFriends; j++) {
                int k = r.nextInt(size);
                if (friends.contains(k) || k == i || k == 0) {
                    j = j == 0 ? 0 : j - 1;
                } else {
                    friends.add(k);
                }

            }
            graph.put(i, friends);
            // System.out.println(friends);

            for (int f : friends)
                System.out.print(f + " ");
            System.out.println();
        }

    }

    public void print() {
        System.out.println(this.graph);
    }

    // public void DFS(int node , List)
}
