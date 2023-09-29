package com.ritesh.datastructures.tree;

public class Recursion {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(n + "! = " + factorial(n));
    }

    private static int factorial(int n) {

        // Recusive Call
        return n == 0 ? 1 : (n * factorial(n - 1));

    }
}
