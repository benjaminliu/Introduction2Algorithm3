package com.ben.introduction2algorithm.datastructure;

/**
 * Created by ben on 2017/7/4.
 */
public class MaxHeap {
    private int capacity;
    private int heapSize;

    public MaxHeap(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must bigger than 0");
        }
        this.capacity = capacity;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return i * 2;
    }

    private int rightChild(int i) {
        return i * 2 + 1;
    }

    public void buildMaxHeap(int[] a) {
        if (a.length > this.capacity) {
            throw new IllegalArgumentException("out of capacity");
        }
        this.heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    public void maxHeapify(int[] arr, int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (l <= this.capacity && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= this.capacity && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest);
        }
    }
}
