package com.ritesh.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        bs.sort(bs.generate(100));

    }

    private ArrayList<Integer> generate(int i) {
        var rnd = new Random(System.nanoTime());
        var arr = new ArrayList<Integer>();

        while (i-- > 0) {
            arr.add(rnd.nextInt(1000));
        }
        arr = (ArrayList<Integer>) (Arrays.asList(0, 2, 18, 26, 35, 62, 62, 71, 83, 85, 86, 87, 95, 107, 111, 114, 121,
                129, 133, 139, 142, 145, 153, 182, 200, 202, 216, 217, 233, 235, 238, 241, 259, 263, 267, 284, 288, 333,
                337, 347, 354, 357, 371, 381, 409, 413, 417, 427, 428, 429, 429, 432, 436, 456, 459, 463, 474, 476, 495,
                500, 525, 532, 536, 562, 562, 573, 574, 575, 577, 613, 615, 650, 657, 668, 672, 690, 721, 726, 758, 766,
                773, 797, 808, 814, 839, 843, 853, 854, 855, 897,
                921, 932, 937, 943, 952, 953, 957, 974, 983, 993))
                .stream()
                .map(t -> Integer.valueOf(t)).collect(Collectors.toList());
        return arr;
    }

    private void sort(ArrayList<Integer> array) {
        System.out.println("BEFORE - " + array);
        long startTime = System.nanoTime();
        int temp;
        int swapCount = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    swapCount++;
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
            if (swapCount == 0) {
                break;
            }
        }
        long endTime = System.nanoTime();
        long diff = (endTime - startTime);
        System.out.println("SWAPCOUNT - " + swapCount + ", TimeTaken = " + diff);
        System.out.println("AFTER - " + array);
    }

}
