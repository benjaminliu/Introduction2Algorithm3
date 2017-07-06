package com.ben.introduction2algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/6.
 * <p>
 * What if you are sorting a lower-case character array,
 * then max value is 25 ( 0 base ),
 * and index is ( c - 'a' )
 */
public class RadixSort {
    public int[] sort(int[] arr, int digitCount) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty array");
        }

        int max = 10;
        List<Integer>[] c = new List[max];
        for (int i = 0; i < max; i++) {
            c[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < digitCount; i++) {
            countingSortByDigit(arr, i, 10, c);
        }

        return arr;
    }

    private void countingSortByDigit(int[] arr, int ind, int max, List<Integer>[] c) {

        for (int i = 0; i < max; i++) {
            c[i].clear();
        }

        for (int i = 0; i < arr.length; i++) {
            c[getDigitByIndex(arr[i], ind)].add(arr[i]);
        }

        int index = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < c[i].size(); j++) {
                arr[index++] = c[i].get(j);
            }
        }
    }

    private int getDigitByIndex(int num, int index) {
        while (index-- > 0) {
            num /= 10;
        }
        return num % 10;
    }
}
