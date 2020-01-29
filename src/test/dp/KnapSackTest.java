package test.dp;

import algo.dp.KnapSack;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class KnapSackTest {

    KnapSack knapSack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        knapSack = new KnapSack();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        knapSack = null;
    }

    @Test
    void testKnapSack() {
        List<Integer> weights = Arrays.asList(1, 3, 4, 5);
        List<Integer> values = Arrays.asList(1, 4, 5, 7);
        int totalWeight = 7;

        int[][] matrix = knapSack.getKnapSackTable(weights, values, totalWeight);

        int maxValue = knapSack.maxValue(matrix);

        List<Integer> selectedWts = knapSack.getSelectedItems(matrix, weights);

        assertEquals(9, maxValue);
        assertEquals(Arrays.asList(4,3), selectedWts);
    }

    @Test
    void testKnapSack2() {
        List<Integer> weights = Arrays.asList(12, 1, 2, 1, 4);
        List<Integer> values = Arrays.asList(4, 2, 2, 1, 10);
        int totalWeight = 15;

        int[][] matrix = knapSack.getKnapSackTable(weights, values, totalWeight);

        int maxValue = knapSack.maxValue(matrix);

        List<Integer> selectedWts = knapSack.getSelectedItems(matrix, weights);

        assertEquals(15, maxValue);
        assertEquals(Arrays.asList(4,1,2,1), selectedWts);
    }

    @Test
    void testKnapSack3() {
        List<Integer> weights = Arrays.asList(3, 4, 5, 9, 4);
        List<Integer> values = Arrays.asList(3, 4, 4, 10, 4);
        int totalWeight = 11;

        int[][] matrix = knapSack.getKnapSackTable(weights, values, totalWeight);

        int maxValue = knapSack.maxValue(matrix);

        List<Integer> selectedWts = knapSack.getSelectedItems(matrix, weights);

        assertEquals(11, maxValue);
        assertEquals(Arrays.asList(4,4,3), selectedWts);
    }
}
