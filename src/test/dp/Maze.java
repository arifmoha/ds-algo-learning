package test.dp;

import algo.dp.models.Point;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    public List<Point> getPath(boolean[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Point> path = new ArrayList<>();
        getPath(matrix, rows - 1, cols - 1, path);

        return path;

    }

    public boolean getPath(boolean[][] matrix, int row, int col, List<Point> path) {

        if (row < 0 || col < 0 || !matrix[row][col])
            return false;
        if(matrix[row][col]) return true;

        boolean isOrigin = row == 0 && col == 0;

        // moving back wards.
        boolean hasPathUp = getPath(matrix, row - 1, col, path);
        boolean hasPathLeft = getPath(matrix, row, col - 1, path);

        if (isOrigin || hasPathUp || hasPathLeft) {
            new Point(row, col);
            return true;
        }

        // false points can be cached, to reduce time.
        return false;
    }
}
