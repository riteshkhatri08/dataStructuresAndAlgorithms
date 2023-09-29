package com.ritesh.practice.sorting;

public class BinarySearch {
    static int[] array = { 1, 2, 4, 5, 23, 44, 67, 68, 69, 69, 99, 102, 122 };

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        int searchNum = 69;

        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        int idx = obj.search(searchNum, left, right, middle);
        // int idx = obj.bsIterative(searchNum);
        System.out.println(idx);
    }

    private int bsIterative(int searchNum) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;

        while (!(left > right)) {
            System.out.println(left + ", " + mid + ", " + right);
            mid = (left + right) / 2;
            if (array[mid] == searchNum)
                return mid;
            if (array[right] == searchNum)
                return right;
            if (array[left] == searchNum)
                return left;

            if (array[mid] < searchNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int search(int num, int left, int right, int mid) {
        System.out.println(mid + ", " + left + ", " + right);
        mid = (left + right) / 2;

        if (left > right)
            return -1;

        if (array[mid] == num)
            return mid;

        if (array[left] == num)
            return left;

        if (array[right] == num)
            return right;

        if (num < array[mid]) {
            right = mid + 1;

            return search(num, left, right, mid);

        } else {
            left = mid - 1;
            return search(num, left, right, mid);
        }
    }
}
