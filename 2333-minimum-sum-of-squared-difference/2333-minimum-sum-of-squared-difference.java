class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
        }

        Arrays.sort(diff);

        long total = 0;

        for (long d : diff) {
            total += d;
        }

        if (k >= total) {
            return 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            long count = n - i;
            long next = (i == 0) ? 0 : diff[i - 1];
            long gap = diff[i] - next;
            long required = gap * count;

            if (k >= required) {
                k -= required;
            } else {
                long decrease = k / count;
                long remainder = k % count;

                long level = diff[i] - decrease;

                long ans = 0;

                for (int j = 0; j < i; j++) {
                    ans += diff[j] * diff[j];
                }

                ans += (count - remainder) * level * level;

                if (remainder > 0) {
                    long lower = level - 1;
                    ans += remainder * lower * lower;
                }

                return ans;
            }
        }

        return 0;
    }
}