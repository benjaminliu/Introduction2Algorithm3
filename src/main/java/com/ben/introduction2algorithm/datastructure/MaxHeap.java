package com.ben.introduction2algorithm.datastructure;

/**
 * Created by ben on 2017/7/4.
 */
public class MaxHeap {

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return i * 2;
    }

    private int rightChild(int i) {
        return i * 2 + 1;
    }

    public int[] buildMaxHeap(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("empty heap");
        }

        int capacity = a.length;
        for (int i = capacity / 2; i >= 0; i--) {
            maxHeapify(a, i, capacity);
        }
        return a;
    }

    public void maxHeapify(int[] arr, int i, int heapSize) {
        if (arr.length < heapSize) {
            throw new IllegalArgumentException("Heap capacity is smaller than heap size");
        }
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (l < heapSize && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest, heapSize);
        }
    }
}
