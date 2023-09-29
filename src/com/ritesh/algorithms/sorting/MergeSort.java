package com.ritesh.algorithms.sorting;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSort {

    Integer[] mergeSort(Integer[] array) {

        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;
        Integer[] left = mergeSort(subArray(0, middle, array));
        Integer[] right = mergeSort(subArray(middle, array.length, array));
        return merge(left, right);
    }

    private Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] result = new Integer[left.length + right.length];

        int pleft = 0, pright = 0, index = 0;

        while (pleft < left.length && pright < right.length) {

            if (left[pleft] <= right[pright]) {
                result[index++] = left[pleft++];
            } else {
                result[index++] = right[pright++];
            }

        }

        while (pright < right.length) {
            result[index++] = right[pright++];
        }
        while (pleft < left.length) {
            result[index++] = left[pleft++];
        }

        return result;
    }

    Integer[] subArray(int start, int stop, Integer[] inputArray) {
        Integer[] subArray = new Integer[stop - start];

        for (int index = 0; index < stop - start; index++) {
            subArray[index] = inputArray[start + index];
        }
        return subArray;
    }

    public static void main(String[] args) {
        var ms = new MergeSort();
        ms.populate();
        ms.print();
        ms.arr = ms.mergeSort(ms.arr);
        ms.print();
    }

    Integer[] arr = new Integer[19];
    Random random = new Random(System.nanoTime());

    int supplyInt() {
        return random.nextInt(100);

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
}
