package algo.dp;

import test.dp.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public void minCoinsRecur(int[] coins, int total) {
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            minCoins(coins, total, i, coins[i], minCoins, new ArrayList<>(coins[i]));
        }
    }

    private void minCoins(int[] coins, int total, int index, int sum, int minCoins, List<Integer> list) {
        if (sum == total) {
            if (list.size() < minCoins) {
                minCoins = list.size();
                System.out.println("min coins list: " + list);
            }
        }

        for (int i = index + 1; i < coins.length; i++) {
            list.add(coins[i]);
            minCoins(coins, total, i, sum + coins[i], minCoins, list);
        }

    }

    public int minCoins(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[rows - 1][cols - 1];
    }

    public int[][] getCoinChangeMatrix(int[] coins, int total) {
        int rows = coins.length + 1;
        int cols = total + 1;

        int[][] matrix = new int[rows][cols];

        for (int col = 1; col < cols; col++) {
            matrix[1][col] = col / coins[0];
        }

        for (int row = 2; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                int curTotal = col;
                int curCoin = coins[row - 1];

                if (curCoin == curTotal) {
                    matrix[row][col] = 1;
                } else if (curCoin > curTotal) {
                    matrix[row][col] = matrix[row - 1][col];
                } else {
                    // curCoin < curTotal
                    int remTotal = curTotal - curCoin;

                    // curCoin of the same row
                    // curCoin of the previous row

                    int thisCoinMin = Math.min(matrix[row][curCoin], matrix[row - 1][curCoin]);
                    int remCoinMin = Math.min(matrix[row][remTotal], matrix[row - 1][remTotal]);

                    int newMin = thisCoinMin + remCoinMin;
                    int oldMin = matrix[row - 1][col];

                    matrix[row][col] = Math.min(oldMin, newMin);
                }
            }
        }

        // TestUtil.printMatrix(matrix);

        return matrix;
    }

    public List<Integer> getCoinsSelected(int[][] matrix, int[] coins) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1;
        int col = cols - 1;

        List<Integer> selCoins = new ArrayList<>();
        while (row > 0) {
            int curVal = matrix[row][col];
            int preVal = matrix[row - 1][col];

            if (curVal >= preVal) {
                row = row - 1;
            } else {
                selCoins.add(coins[row - 1]);
                row = row - 1;
            }
        }

        return selCoins;
    }

    public static long getWays(int n, List<Long> c) {

        long[][] matrix = getWaysMatrix(n, c);

        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[rows - 1][cols - 1];

    }

    public static long[][] getWaysMatrix(int n, List<Long> c) {

        int rows = c.size() + 1;
        int cols = n + 1;

        long[][] matrix = new long[rows][cols];

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                long coinVal = c.get((int) row - 1);
                long totalVal = col;

                if (coinVal == totalVal) {
                    matrix[row][col] = matrix[row - 1][col] + 1;
                } else if (coinVal < totalVal) {
                    int rem = (int) (totalVal - coinVal);
                    matrix[row][col] = matrix[row - 1][col] + matrix[row][rem];
                } else {
                    matrix[row][col] = matrix[row - 1][col];
                }
            }
        }

        return matrix;
    }
}
