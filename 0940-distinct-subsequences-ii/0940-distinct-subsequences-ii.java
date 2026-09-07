class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;

        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long newSub = (total + 1) % MOD;

            total = (total + newSub - dp[idx] + MOD) % MOD;

            dp[idx] = newSub;
        }

        return (int) total;
    }
}