package com.ben.introduction2algorithm.sort;

/**
 * Created by ben on 2017/7/5.
 */
public class QuickSort {
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
        int x = arr[right];
        int i = left - 1;
        int temp;
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
