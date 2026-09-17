class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = Integer.MAX_VALUE;

        int left = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + dp[left - 1]);
                }

                dp[right] = len;
            }

            if (right > 0) {
                dp[right] = Math.min(dp[right], dp[right - 1]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}