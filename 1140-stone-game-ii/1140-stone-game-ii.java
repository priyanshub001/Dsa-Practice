class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    int solve(int i, int M) {

        if (i + 2 * M >= n) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int ans = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(i + X, Math.max(M, X));

            int currentPlayer = suffix[i] - opponent;

            ans = Math.max(ans, currentPlayer);
        }

        dp[i][M] = ans;

        return ans;
    }
}