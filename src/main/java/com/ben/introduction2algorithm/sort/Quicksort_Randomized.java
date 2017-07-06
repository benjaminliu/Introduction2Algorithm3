package com.ben.introduction2algorithm.sort;

import java.util.Random;

/**
 * Created by ben on 2017/7/6.
 */
public class Quicksort_Randomized {

    private Random random = new Random();

    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty array");
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = randomizedPartition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private int randomizedPartition(int[] arr, int left, int right) {
        int temp = 0;
        int diff = right - left;
        if (diff > 0) {
            int some = random.nextInt(diff) + left;
            temp = arr[right];
            arr[right] = arr[some];
            arr[some] = temp;
        }

        int x = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= x) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
}
