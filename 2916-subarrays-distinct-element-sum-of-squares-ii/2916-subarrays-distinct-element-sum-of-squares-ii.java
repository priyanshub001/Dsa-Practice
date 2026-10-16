class Solution {
    static final int MOD = 1000000007;

    long[] sum;
    long[] sq;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;

            update(1, 0, n - 1, l, i);

            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void apply(int node, int start, int end, long val) {
        long len = end - start + 1;
        sq[node] = (sq[node] + 2 * val * sum[node] % MOD
                + len * val % MOD * val) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = (start + end) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int start, int end, int l, int r) {
        if (start > r || end < l) {
            return;
        }

        if (l <= start && end <= r) {
            apply(node, start, end, 1);
            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r);
        update(node * 2 + 1, mid + 1, end, l, r);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}