package com.ritesh.datastructures.stack;

import java.util.ArrayList;

public class MaxStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> max;

    public MaxStack() {
        stack = new ArrayList<Integer>();
        max = new ArrayList<Integer>();

    }

    public void push(int num) {
        stack.add(num);

        if (max.size() == 0) {
            max.add(num);
        } else if (num >= (this.getMax())) {
            max.add(num);
        }

        System.out.println("STACK " + stack);
        System.out.println("MINSTACK " + max);

    }

    public Integer pop() {

        int num = stack.remove(stack.size() - 1);
        if (this.getMax() == num) {
            max.remove(max.size() - 1);
        }

        return num;
    }

    public Integer peek() {

        return stack.get(stack.size() - 1);
    }

    public Integer getMax() {
        return max.get(max.size() - 1);
    }

    public static void main(String[] args) {
        var maxStack = new MaxStack();
        for (int c : new int[] {7,9,1,5 })
            maxStack.push(c);

    }
}
