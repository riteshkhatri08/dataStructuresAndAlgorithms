package com.ritesh.practice.sorting;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    Integer[] arr = new Integer[10];
    Random random = new Random(System.nanoTime());

    int supplyInt() {
        return random.nextInt(10);

    }

    private void populate() {

        this.arr = Stream
                .generate(this::supplyInt)
                .limit(this.arr.length)
                .collect(Collectors.toList()).toArray(this.arr);
    }

    private void print() {
        for (int a : this.arr)
            System.out.print(a + " ");
        System.out.println("");

    }

    private void quickSort(int start, int stop) {
        if (start < stop){
           
      
        int pivot = this.partition(start, stop);
        quickSort(start,pivot-1);
        quickSort(pivot+1, stop);

        }
    }

    private int partition(int start, int stop) {

        int pivot = start, left = start + 1, right = stop, temp;

        while (left <= right) {

            // switch if we found idex where left is higher than pivot and right is lower
            // than pivot
            if (arr[left] >= arr[pivot] && arr[right] <= arr[pivot]) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                this.print();
            }
            // move left towards left if value at current left is already lower than value
            // at pivot
            if (arr[left] <= arr[pivot])
                left++;

            // move right towards right if value at current right is already higher than
            // value at pivot
            if (arr[right] >= arr[pivot])
                right--;

        }

        // switch values at index of right and pivot
        temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        this.print();
        // update value of pivot as right
        pivot = right;

        // return index of pivot element
        return pivot;

    }

    public static void main(String[] args) {
        var qs = new QuickSort();
        qs.populate();
        qs.print();
        qs.quickSort(0, qs.arr.length - 1);
        qs.print();
    }

}
