package algo.dp;

import test.dp.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {
    public int[][] getKnapSackTable(List<Integer> weights, List<Integer> values, int totalWeight) {
        int rows = weights.size() + 1;
        int cols = totalWeight + 1;

        int[][] matrix = new int[rows][cols];

        init(matrix, rows, cols);

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                int totalWtNow = col;
                int itemWt = weights.get(row - 1);
                int itemVal = values.get(row - 1);
                int prevMaxVal = matrix[row - 1][col];

                if (itemWt <= totalWtNow) {
                    int remWt = totalWtNow - itemWt;
                    // to get the remaining wt's value, go to previous row, to remWt col
                    int remVal = matrix[row - 1][remWt];

                    int totalValNow = itemVal + remVal;

                    matrix[row][col] = Math.max(totalValNow, prevMaxVal);
                } else {
                    matrix[row][col] = prevMaxVal;
                }
            }
        }
        // uncomment for debugging.
        // TestUtil.printMatrix(matrix);

        return matrix;
    }

    public int maxValue(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[rows - 1][cols - 1];
    }

    public List<Integer> getSelectedItems(int[][] matrix, List<Integer> weights) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1;
        int col = cols - 1;

        List<Integer> selectedWts = new ArrayList<>();

        while (row > 0 && col > 0) {
            int maxVal = matrix[row][col];
            int prevMaxVal = matrix[row - 1][col];

            if (maxVal == prevMaxVal) {
                // go to previous row
                row = row - 1;
            } else {
                // item is selected
                int wtSelected = weights.get(row - 1);

                System.out.println("Selected Weight: " + wtSelected);
                selectedWts.add(wtSelected);

                int totalWtNow = col;

                int remWt = totalWtNow - wtSelected;

                row = row - 1;
                col = remWt;
            }
        }

        return selectedWts;
    }

    private void init(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }
    }
}
