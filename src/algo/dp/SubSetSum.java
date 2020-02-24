package algo.dp;

import test.dp.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //  int[] arr = {1, 2, 3};
        int K = 12;
        // the below is to print the subsets.

//        List<List<Integer>> subSets = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            subSet(arr, i, new ArrayList<>(), subSets);
//        }
//
//        System.out.println(subSets);

        for (int i = 0; i < arr.length; i++) {
            subSetSum(arr, i, new ArrayList<>(), arr[i], K);
        }
    }


    private static void subSet(int[] arr, int index, List<Integer> list, List<List<Integer>> subSets) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(arr[index]);
        subSets.add(newList);

        for (int i = index + 1; i < arr.length; i++) {
            subSet(arr, i, newList, subSets);
        }
    }

    private static void subSetSum(int[] arr, int index, List<Integer> list, int sum, int K) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(arr[index]);

        if (sum == K) {
            System.out.println(newList);
        }

        for (int i = index + 1; i < arr.length; i++) {
            subSetSum(arr, i, newList, sum + arr[i], K);
        }
    }

    public boolean isSubSetSum(boolean[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[rows - 1][cols - 1];
    }


    public boolean[][] getSubSetMatrix(int[] arr, int sum) {
        int cols = sum + 1;
        int rows = arr.length + 1;

        boolean[][] matrix = new boolean[rows][cols];

        init(matrix, rows, cols);
        // col with total 0 is true.
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                int element = arr[row - 1];
                int totalSumNow = col;

                if (element > totalSumNow) {
                    // previous row, same col value
                    matrix[row][col] = matrix[row - 1][col];
                }

                if (element <= totalSumNow) {
                    if (!matrix[row - 1][col]) {
                        // go previous row
                        // go remaining col

                        int remSum = totalSumNow - element;
                        matrix[row][col] = matrix[row - 1][remSum];
                    } else {
                        matrix[row][col] = true;
                    }
                }
            }
        }

        // for debugging
        // TestUtil.printMatrix(matrix);

        return matrix;
    }

    private void init(boolean[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = false;
            }
        }
    }

    public List<Integer> subSetSum(boolean[][] matrix, int[] arr) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> subSet = new ArrayList<>();

        int row = rows - 1;
        int col = cols - 1;

        if(!matrix[row][col]) return subSet;

        while (row > 0 && col > 0) {
            if (!matrix[row - 1][col]) {
                // select row, col
                // col = remaining
                int sumNow = col;
                int ele = arr[row - 1];
                subSet.add(ele);

                col = sumNow - ele;
                row = row-1;
            } else {
                row = row - 1;
            }
        }

        return subSet;

    }
}
