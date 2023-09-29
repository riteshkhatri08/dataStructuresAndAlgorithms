package com.ritesh.datastructures.stack;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> min;

    public MinStack() {
        stack = new ArrayList<Integer>();
        min = new ArrayList<Integer>();

    }

    public void push(int num) {
        stack.add(num);

        if (min.size() == 0) {
            min.add(num);
        } else if (num <= (this.getMin())) {
            min.add(num);
        }

        System.out.println("STACK " + stack);
        System.out.println("MINSTACK " + min);

    }

    public Integer pop() {

        int num = stack.remove(stack.size() - 1);
        if (this.getMin() == num) {
            min.remove(min.size() - 1);
        }

        return num;
    }

    public Integer peek() {

        return stack.get(stack.size() - 1);
    }

    public Integer getMin() {
        return min.get(min.size() - 1);
    }

    public static void main(String[] args) {
        var minStack = new MinStack();
        for (int c : new int[] {0,1,0 })
            minStack.push(c);

    }
}
