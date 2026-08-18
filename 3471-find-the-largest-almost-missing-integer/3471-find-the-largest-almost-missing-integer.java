class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == n) {
            int max = -1;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        int[] count = new int[51];

        for (int num : nums) {
            count[num]++;
        }

        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (count[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        int ans = -1;

        if (count[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (count[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}