package com.ben.introduction2algorithm.sort;

/**
 * Created by ben on 2017/7/4.
 */
public class InsertionSort {
    public int[] sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        int length = arr.length;
        int temp;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    public int[] sort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        int length = arr.length;
        int temp;
        int j;
        for (int i = 1; i < length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}
