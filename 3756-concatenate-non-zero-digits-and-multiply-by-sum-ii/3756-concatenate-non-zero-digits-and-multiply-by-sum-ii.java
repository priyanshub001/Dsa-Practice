class Solution {

        private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        
        int n = s.length();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digits.add(d);
            }
        }

        int k = digits.size();

        long[] pref = new long[k + 1];
        long[] preSum = new long[k + 1];
        long[] pow10 = new long[k + 1];

        pow10[0] = 1;
        for (int i = 1; i <= k; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < k; i++) {
            pref[i + 1] = (pref[i] * 10 + digits.get(i)) % MOD;
            preSum[i + 1] = preSum[i] + digits.get(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int L = lowerBound(pos, l);
            int R = upperBound(pos, r) - 1;

            if (L > R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L + 1;

            long sum = preSum[R + 1] - preSum[L];

            long concat =
                    (pref[R + 1]
                            - (pref[L] * pow10[len]) % MOD
                            + MOD)
                            % MOD;

            ans[i] = (int) ((concat * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}