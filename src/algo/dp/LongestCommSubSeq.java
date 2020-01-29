package algo.dp;

import test.dp.TestUtil;

import java.util.Arrays;

public class LongestCommSubSeq {
    public int[][] getTableWithLen(String s1, String s2) {
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        int[][] matrix = new int[rows][cols];

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1] + 1;
                } else {
                    matrix[row][col] = Math.max(matrix[row][col - 1], matrix[row - 1][col]);
                }
            }
        }
        // uncomment for debugging.
        // TestUtil.printMatrix(matrix);

        return matrix;
    }

    public int getSubSeqCount(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[rows - 1][cols - 1];
    }

    public String getLongSubSeq(int[][] matrix, String s) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1;
        int col = cols - 1;

        char[] subSeqArr = new char[matrix[rows - 1][cols - 1]];
        int index = subSeqArr.length - 1;

        // StringBuilder sb = new StringBuilder();

        while (row > 0 && col > 0) {
            if (matrix[row][col - 1] == matrix[row - 1][col]) {
                if (matrix[row][col] == matrix[row - 1][col - 1] + 1) {
                    // go diagonal
                    // found the character
                    // sb.insert(0, s.charAt(row - 1));
                    subSeqArr[index] = s.charAt(row - 1);
                    index--;

                    row = row - 1;
                    col = col - 1;
                } else {
                    // previous row
                    row = row - 1;
                }
            } else if (matrix[row][col - 1] > matrix[row - 1][col]) {
                col = col - 1;
            } else {
                row = row - 1;
            }
        }

        return String.valueOf(subSeqArr);
    }
}
