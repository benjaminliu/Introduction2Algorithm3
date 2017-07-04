package com.ben.introduction2algorithm.others;

/**
 * Created by ben on 2017/7/4.
 */
public class SquareMatrixMultiply {
    public int[][] multiply(int[][] a, int[][] b) {
        if (a == null || b == null || a[0] == null || b[0] == null) {
            throw new IllegalArgumentException("a,b must be n*n matrix");
        }
        if (a.length != b.length || a[0].length != b[0].length || a.length != a[0].length) {
            throw new IllegalArgumentException("a,b must be n*n matrix");
        }
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
