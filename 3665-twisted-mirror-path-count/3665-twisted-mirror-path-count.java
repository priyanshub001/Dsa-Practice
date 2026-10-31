class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 1000000007;

        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long r = right[i][j];
                long d = down[i][j];

                if (i == m - 1 && j == n - 1) {
                    return (int)((r + d) % mod);
                }

                if (grid[i][j] == 1) {
                    if (i + 1 < m)
                        down[i + 1][j] = (down[i + 1][j] + r) % mod;

                    if (j + 1 < n)
                        right[i][j + 1] = (right[i][j + 1] + d) % mod;

                } else {
                    if (j + 1 < n)
                        right[i][j + 1] = (right[i][j + 1] + r + d) % mod;

                    if (i + 1 < m)
                        down[i + 1][j] = (down[i + 1][j] + r + d) % mod;
                }
            }
        }

        return 0;
    }
}