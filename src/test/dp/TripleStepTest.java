package test.dp;

import algo.dp.CoinChange;
import algo.dp.TripleStep;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripleStepTest {
    TripleStep ts;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ts = new TripleStep();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        ts = null;
    }

    @Test
    void testTripleStep() {
        assertEquals(13, ts.countWays(5));
        assertEquals(24, ts.countWays(6));
        assertEquals(44, ts.countWays(7));
        assertEquals(81, ts.countWays(8));
        assertEquals(149, ts.countWays(9));
        assertEquals(274, ts.countWays(10));

        // System.out.println(ts.countWays(37));
    }
}
