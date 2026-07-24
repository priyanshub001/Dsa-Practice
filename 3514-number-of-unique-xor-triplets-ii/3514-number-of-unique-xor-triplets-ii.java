class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int v : nums) {
            boolean[][] next = new boolean[4][MAX];

            // Copy "take 0 times"
            for (int k = 0; k <= 3; k++) {
                System.arraycopy(dp[k], 0, next[k], 0, MAX);
            }

            for (int k = 0; k <= 3; k++) {
                for (int x = 0; x < MAX; x++) {
                    if (!dp[k][x]) continue;

                    // take once
                    if (k + 1 <= 3)
                        next[k + 1][x ^ v] = true;

                    // take twice
                    if (k + 2 <= 3)
                        next[k + 2][x] = true;

                    // take three times
                    if (k + 3 <= 3)
                        next[k + 3][x ^ v] = true;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (int x = 0; x < MAX; x++) {
            if (dp[3][x]) ans++;
        }

        return ans;
    }
}