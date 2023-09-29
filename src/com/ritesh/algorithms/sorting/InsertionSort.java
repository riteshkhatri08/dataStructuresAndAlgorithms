package com.ritesh.algorithms.sorting;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        // Scanner sc = new Scanner (System.in);

        // String line = sc.nextLine();
        // String line;
        // while (!(line = sc.nextLine()).equals("exit")){
        // if(line.matches("\\d")){
        // Integer.parseInt(line.trim());
        // }

        // }

        int[] arr = { 9, 5, 1, 10, 4, 22 };
        sort(arr);
    }

    private static void sort(int[] arr) {
        // int sortedCount = 1;
        // int temp;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }

        for (int as : arr) {
            System.out.print(as + " ");
        }

    }
}
