package com.ben.introduction2algorithm.selection;

import java.util.Random;

/**
 * Created by ben on 2017/7/6.
 */
public class RandomizedSelect {
    private Random random = new Random();

    public int select(int[] arr, int i) {
        if (null == arr || arr.length < 1) {
            throw new IllegalArgumentException("Empty list");
        }
        if (i < 0 || i > arr.length) {
            throw new IllegalArgumentException("Out of range");
        }

        return randomizeSelect(arr, 0, arr.length - 1, i);
    }

    private int randomizeSelect(int[] arr, int left, int right, int i) {
        if (left == right) {
            return arr[left];
        }

        int mid = randomizedPartition(arr, left, right);

        int k = mid - left + 1;
        if (i == k) {
            return arr[mid];
        } else if (i < k) {
            return randomizeSelect(arr, left, mid - 1, i);
        } else {
            return randomizeSelect(arr, mid + 1, right, i - k);
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
