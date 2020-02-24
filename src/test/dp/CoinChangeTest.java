package test.dp;

import algo.dp.CoinChange;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CoinChangeTest {
    CoinChange cc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cc = new CoinChange();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        cc = null;
    }

    @Test
    void testCoinChange(){
        int[] coins = {1,5,6,8};

        int[][] matrix = cc.getCoinChangeMatrix(coins, 11);

        assertEquals(2, cc.minCoins(matrix));

        assertEquals(Arrays.asList(6,5), cc.getCoinsSelected(matrix, coins));

    }

    @Test
    void testCoinChange2(){
        int[] coins = {1,5,10};

        int[][] matrix = cc.getCoinChangeMatrix(coins, 8);

        assertEquals(2, cc.minCoins(matrix));

       // assertEquals(Arrays.asList(6,5), cc.getCoinsSelected(matrix, coins));

    }

    @Test
    void testCoinChangeWays(){
       // lon[] coins = {1,2,3};

        List<Long> coins = new ArrayList<>(Arrays.asList(1l,2l,3l));

       // long[][] matrix = cc.getWaysMatrix(5, coins);

       // TestUtil.printMatrix(matrix);

        assertEquals(5, cc.getWays(5, coins));

       // assertEquals(2, cc.minCoins(matrix));

        // assertEquals(Arrays.asList(6,5), cc.getCoinsSelected(matrix, coins));

    }
}
