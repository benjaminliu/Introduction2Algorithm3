package com.ben.introduction2algorithm.sort;

import com.ben.introduction2algorithm.datastructure.MaxHeap;

/**
 * Created by ben on 2017/7/5.
 */
public class HeapSort {
    public int[] sort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }

        MaxHeap heap = new MaxHeap();
        arr = heap.buildMaxHeap(arr);
        int temp;
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap.maxHeapify(arr, 0, --heapSize);
        }

        return arr;
    }
}
