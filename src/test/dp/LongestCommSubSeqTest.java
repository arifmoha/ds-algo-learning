package test.dp;

import algo.dp.LongestCommSubSeq;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommSubSeqTest {

    LongestCommSubSeq lcs;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        lcs = new LongestCommSubSeq();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        lcs = null;
    }

    @Test
    void testLongCommSubSeq(){

       int[][] table = lcs.getTableWithLen("abcdaf", "acbcf");

       assertEquals(4, lcs.getSubSeqCount(table));
       assertEquals("abcf", lcs.getLongSubSeq(table, "abcdaf"));
    }

    @Test
    void testLongCommSubSeq2(){
        int[][] table = lcs.getTableWithLen("AGGTAB", "GXTXAYB");

        assertEquals(4, lcs.getSubSeqCount(table));
        assertEquals("GTAB", lcs.getLongSubSeq(table, "AGGTAB"));
    }

    @Test
    void testLongCommSubSeq3(){
        int[][] table = lcs.getTableWithLen("12341", "341213");

        assertEquals(3, lcs.getSubSeqCount(table));
        assertEquals("121", lcs.getLongSubSeq(table, "12341"));
    }
}
