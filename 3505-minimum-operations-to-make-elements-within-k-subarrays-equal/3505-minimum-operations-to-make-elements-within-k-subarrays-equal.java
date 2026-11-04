import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long leftSum = 0, rightSum = 0;
        int leftSize = 0, rightSize = 0;

        void addLeft(int val) {
            left.put(val, left.getOrDefault(val, 0) + 1);
            leftSum += val;
            leftSize++;
        }

        void addRight(int val) {
            right.put(val, right.getOrDefault(val, 0) + 1);
            rightSum += val;
            rightSize++;
        }

        void removeLeft(int val) {
            left.put(val, left.get(val) - 1);
            if (left.get(val) == 0) left.remove(val);
            leftSum -= val;
            leftSize--;
        }

        void removeRight(int val) {
            right.put(val, right.get(val) - 1);
            if (right.get(val) == 0) right.remove(val);
            rightSum -= val;
            rightSize--;
        }

        void rebalance() {
            int total = leftSize + rightSize;
            int targetLeft = (total + 1) / 2;

            while (leftSize > targetLeft) {
                int val = left.lastKey();
                removeLeft(val);
                addRight(val);
            }

            while (leftSize < targetLeft) {
                int val = right.firstKey();
                removeRight(val);
                addLeft(val);
            }
        }

        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                addLeft(val);
            } else {
                addRight(val);
            }
            rebalance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeLeft(val);
            } else {
                removeRight(val);
            }
            rebalance();
        }

        long getCost() {
            long median = left.lastKey();

            return median * leftSize - leftSum
                    + rightSum - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int windows = n - x + 1;
        long[] cost = new long[windows];

        MedianWindow mw = new MedianWindow();

        // First window
        for (int i = 0; i < x; i++) {
            mw.add(nums[i]);
        }

        cost[0] = mw.getCost();

        // Sliding window
        for (int i = 1; i < windows; i++) {
            mw.remove(nums[i - 1]);
            mw.add(nums[i + x - 1]);

            cost[i] = mw.getCost();
        }

        // DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        Arrays.fill(dp[0], 0);

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {

                // Skip current element
                dp[j][i] = dp[j][i - 1];

                // Take a subarray of size x
                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                            dp[j][i],
                            dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}