package com.ben.introduction2algorithm.datastructure;

/**
 * Created by ben on 2017/7/5.
 */
public class MaxPriorityQueue {
    private MaxHeap maxHeap;

    public MaxPriorityQueue(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Empty heap");
        }
        maxHeap = new MaxHeap(arr);
    }

    public int heapMaximum() {
        return maxHeap.get(0);
    }

    public int heapExtractMax() throws Exception {
        int max = maxHeap.get(0);
        maxHeap.set(0, maxHeap.getHeapSize());
        maxHeap.heapSizeDecrease();
        maxHeap.maxHeapify(0);
        return max;
    }

    public void heapIncreaseKey(int i, int key) throws Exception {
        if (i > maxHeap.getHeapSize()) {
            throw new IllegalArgumentException("out of bound");
        }
        if (key < maxHeap.get(i)) {
            throw new Exception("new key is smaller than current key");
        }
        maxHeap.set(i, key);
        while (i > 0 && maxHeap.get(maxHeap.parent(i)) < maxHeap.get(i)) {
            int temp = maxHeap.get(i);
            maxHeap.set(i, maxHeap.get(maxHeap.parent(i)));
            maxHeap.set(maxHeap.parent(i), temp);
            i = maxHeap.parent(i);
        }
    }

    public void maxHeapInsert(int key) throws Exception {
        maxHeap.heapSizeIncrease();
        maxHeap.set(maxHeap.getHeapSize() - 1, Integer.MIN_VALUE);
        heapIncreaseKey(maxHeap.getHeapSize() - 1, key);
    }
}
