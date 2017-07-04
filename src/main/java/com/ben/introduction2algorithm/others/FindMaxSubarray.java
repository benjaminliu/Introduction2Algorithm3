package com.ben.introduction2algorithm.others;

/**
 * Created by ben on 2017/7/4.
 */
public class FindMaxSubarray {
    public class Subarray {
        public int start;
        public int end;
        public int val;

        public Subarray(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Subarray{" +
                    "start=" + start +
                    ", end=" + end +
                    ", val=" + val +
                    '}';
        }
    }

    public Subarray maxSubarray(int[] arr) {
        return maxSubarray(arr, 0, arr.length - 1);
    }

    private Subarray maxSubarray(int[] arr, int low, int high) {
        if (high == low) {
            return new Subarray(low, high, arr[low]);
        }

        int mid = (low + high) / 2;
        Subarray left = maxSubarray(arr, low, mid);
        Subarray right = maxSubarray(arr, mid + 1, high);
        Subarray cross = maxCrossingSubarray(arr, low, mid, high);
        if (left.val >= right.val && left.val >= cross.val) {
            return left;
        }
        if (right.val >= left.val && left.val >= cross.val) {
            return right;
        }
        return cross;
    }

    private Subarray maxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = -1;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = -1;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Subarray(maxLeft, maxRight, leftSum + rightSum);
    }
}
