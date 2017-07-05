package com.ben.introduction2algorithm.datastructure;

/**
 * Created by ben on 2017/7/4.
 */
public class MaxHeap {

    private int[] arr;
    private int capacity;
    private int heapSize;

    public int[] getArr() {
        return arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public MaxHeap(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty heap");
        }
        this.arr = arr;
        this.capacity = this.heapSize = arr.length;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int leftChild(int i) {
        return i * 2;
    }

    public int rightChild(int i) {
        return i * 2 + 1;
    }

    public void buildMaxHeap() {

        int length = arr.length;
        for (int i = length / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapSizeDecrease() {
        this.heapSize--;
    }

    public void heapSizeIncrease() throws Exception {
        if (heapSize < capacity) {
            this.heapSize++;
        } else {
            throw new Exception("exceed capacity");
        }
    }

    public void maxHeapify(int i) {
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

            maxHeapify(largest);
        }
    }

    public Integer get(int i) {
        if (i > heapSize) {
            throw new IllegalArgumentException("out of bound");
        }

        return arr[i];
    }

    public void set(int i, int value) {
        if (i > heapSize) {
            throw new IllegalArgumentException("out of bound");
        }

        arr[i] = value;
    }
}
