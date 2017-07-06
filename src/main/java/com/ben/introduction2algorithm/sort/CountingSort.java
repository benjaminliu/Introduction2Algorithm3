package com.ben.introduction2algorithm.sort;

/**
 * Created by ben on 2017/7/6.
 */
public class CountingSort {
    public int[] sort(int[] arr, int max) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty array");
        }

        int[] c = new int[max];
        for (int i = 0; i < arr.length; i++) {
            c[arr[i] - 1]++;
        }

        int index = 0;
        for (int i = 1; i < max + 1; i++) {
            for (int j = 0; j < c[i - 1]; j++) {
                arr[index++] = i;
            }
        }

        return arr;
    }
}
