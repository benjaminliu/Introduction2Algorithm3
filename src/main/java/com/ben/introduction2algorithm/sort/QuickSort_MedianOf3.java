package com.ben.introduction2algorithm.sort;

import java.util.Random;

/**
 * Created by ben on 2017/7/6.
 */
public class QuickSort_MedianOf3 {
    private Random random = new Random();

    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty array");
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int temp;
        if (right - left > 3) {
            int med1 = getRandom(left, right);
            int med2 = getRandom(left, right);
            int med3 = getRandom(left, right);

            int pivot = (arr[med1] < arr[med2]) ?
                    (arr[med2] < arr[med3] ? med2 : (arr[med1] < arr[med3] ? med3 : med1)) :
                    (arr[med1] < arr[med3] ? med1 : (arr[med2] < arr[med3] ? med2 : med3));

            temp = arr[pivot];
            arr[pivot] = arr[right];
            arr[right] = temp;
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

    private int getRandom(int left, int right) {
        int diff = right - left;
        return random.nextInt(diff) + left;
    }
}
