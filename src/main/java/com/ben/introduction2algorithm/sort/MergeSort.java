package com.ben.introduction2algorithm.sort;

/**
 * Created by ben on 2017/7/4.
 */
public class MergeSort {
    public int[] sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        split(arr, 0, arr.length - 1);

        return arr;
    }

    private void split(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        split(arr, left, mid);
        split(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] a1 = new int[n1 + 1];
        int[] a2 = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            a1[i] = arr[left + i];
        }
        a1[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            a2[i] = arr[mid + i + 1];
        }
        a2[n2] = Integer.MAX_VALUE;

        int j1 = 0;
        int j2 = 0;
        for (int i = left; i <= right; i++) {
            if (a1[j1] <= a2[j2]) {
                arr[i] = a1[j1++];
            } else {
                arr[i] = a2[j2++];
            }
        }
    }
}
