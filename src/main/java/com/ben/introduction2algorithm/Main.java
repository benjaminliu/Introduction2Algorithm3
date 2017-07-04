package com.ben.introduction2algorithm;

import com.ben.introduction2algorithm.sort.InsertionSort;
import com.ben.introduction2algorithm.sort.MergeSort;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by ben on 2017/7/4.
 */
public class Main {
    public static void main(String args[]) {
        MergeSort m = new MergeSort();
//        int[] sort = m.sort(new int[]{5, 2, 4, 7, 1, 3, 2, 6});
        int[] sort = m.sort(new int[]{3, 41, 52, 26, 38, 57, 9, 49});
        out.print(Arrays.toString(sort));

//        InsertionSort i = new InsertionSort();
//
//        int[] sort = i.sort1(new int[]{6, 5, 4, 1, 2, 3});
//        out.print(Arrays.toString(sort));
    }
}
