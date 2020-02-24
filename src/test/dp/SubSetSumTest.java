package test.dp;

import algo.dp.SubSetSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubSetSumTest {

    SubSetSum subSetSum;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        subSetSum = new SubSetSum();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        subSetSum = null;
    }

    @Test
    void testSubSetSum(){
        int[] arr = {2,3,7,8,10};
        boolean[][] table = subSetSum.getSubSetMatrix(arr, 11);

        assertTrue(subSetSum.isSubSetSum(table));

        assertEquals(Arrays.asList(8,3), subSetSum.subSetSum(table, arr));
    }

    @Test
    void testSubSetSum2(){
        int[] arr = {7,3,2,5,8};
        boolean[][] table = subSetSum.getSubSetMatrix(arr, 14);

        assertTrue(subSetSum.isSubSetSum(table));

        assertEquals(Arrays.asList(5,2,7), subSetSum.subSetSum(table, arr));
    }

    @Test
    void testSubSetSum3(){
        int[] arr = { 2, 9, 10, 1, 99, 3};
        boolean[][] table = subSetSum.getSubSetMatrix(arr, 6);

        assertTrue(subSetSum.isSubSetSum(table));

        assertEquals(Arrays.asList(3,1,2), subSetSum.subSetSum(table, arr));
    }

    @Test
    void testSubSetSum4(){
        int[] arr = { 2, 9, 10, 1, 99, 3};
        boolean[][] table = subSetSum.getSubSetMatrix(arr, 99);

        assertTrue(subSetSum.isSubSetSum(table));

        assertEquals(Arrays.asList(99), subSetSum.subSetSum(table, arr));
    }

    @Test
    void testSubSetSum5(){
        int[] arr = { 2, 9, 1, 3};
        boolean[][] table = subSetSum.getSubSetMatrix(arr, 7);

        assertFalse(subSetSum.isSubSetSum(table));

        assertEquals(Arrays.asList(), subSetSum.subSetSum(table, arr));
    }
}
