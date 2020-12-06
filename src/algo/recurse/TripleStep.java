package algo.recurse;

import java.util.Arrays;

public class TripleStep {
    public int countWaysRecu(int n) {
        if (n < 0) return 0;

        if (n == 0) return 1;

        return countWaysRecu(n - 1) + countWaysRecu(n - 2) + countWaysRecu(n - 3);
    }

    public long countWays(int n) {
        long[] memo = new long[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

       // System.out.println(Arrays.toString(memo));

        return memo[n];
    }
}
