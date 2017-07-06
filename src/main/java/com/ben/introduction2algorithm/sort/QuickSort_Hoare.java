package com.ben.introduction2algorithm.sort;

/**
 * Created by ben on 2017/7/6.
 */
public class QuickSort_Hoare {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty array");
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = hoarePartition(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid + 1, right);
        }
    }

    private int hoarePartition(int[] arr, int left, int right) {
        int x = arr[left];
        int i = left - 1;
        int j = right + 1;
        int temp;

        while (true) {
            do {
                j--;
            } while (arr[j] > x);
            do {
                i++;
            } while (arr[i] < x);

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                return j;
            }
        }
    }
}
