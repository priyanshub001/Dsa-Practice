class Solution {
    public boolean hasValidPath(char[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        // Valid parentheses string must have even length
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        // Maximum possible balance
        int maxBalance = m + n;

        boolean[][][] dp = new boolean[m][n][maxBalance];

        // Starting cell
        if (grid[0][0] == ')') {
            return false;
        }

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance < maxBalance; balance++) {

                    int newBalance;

                    if (grid[i][j] == '(') {
                        newBalance = balance + 1;
                    } else {
                        newBalance = balance - 1;
                    }

                    // Balance can never be negative
                    if (newBalance < 0 || newBalance >= maxBalance) {
                        continue;
                    }

                    // Come from top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // At the end balance must be 0
        return dp[m - 1][n - 1][0];
    }
}