package com.ben.introduction2algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/6.
 */
public class BucketSort {
    public Double[] sort(Double[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int bucketNo = 10;
        List<Double>[] buckets = new List[bucketNo];
        for (int i = 0; i < bucketNo; i++) {
            buckets[i] = new ArrayList<Double>();
        }

        for (int i = 0; i < n; i++) {
            int index = (int) (arr[i] * bucketNo);
            buckets[index].add(arr[i]);
        }

        int index = 0;

        for (List<Double> list : buckets) {
            Double[] ds = new Double[list.size()];
            ds = list.toArray(ds);

            insertSort(ds);

            //merge bucket
            for (Double d : ds) {
                arr[index++] = d;
            }
        }

        return arr;
    }

    private void insertSort(Double[] arr) {
        int length = arr.length;
        Double temp;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }
    }
}
