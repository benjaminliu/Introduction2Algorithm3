package com.ben.introduction2algorithm;

import com.ben.introduction2algorithm.others.FindMaxSubarray;
import com.ben.introduction2algorithm.sort.HeapSort;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by ben on 2017/7/4.
 */
public class Main {
    public static void main(String args[]) {
        HeapSort h = new HeapSort();
        int[] sort = h.sort(new int[]{5, 2, 4, 7, 1, 3, 2, 6});
        out.print(Arrays.toString(sort));

//        FindMaxSubarray f = new FindMaxSubarray();
////        int i = f.find(new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97});
////        FindMaxSubarray.Subarray i = f.maxSubarray(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
//        FindMaxSubarray.Subarray i = f.maxSubarray(new int[]{-13, -3, -25, -20, -3, -16, -23, -18, -20, -7, -12, -5, -22, -15, -4, -7});
//        out.print(i);

//        MergeSort m = new MergeSort();
////        int[] sort = m.sort(new int[]{5, 2, 4, 7, 1, 3, 2, 6});
//        int[] sort = m.sort(new int[]{3, 41, 52, 26, 38, 57, 9, 49});
//        out.print(Arrays.toString(sort));

//        InsertionSort i = new InsertionSort();
//
//        int[] sort = i.sort1(new int[]{6, 5, 4, 1, 2, 3});
//        out.print(Arrays.toString(sort));
    }
}
