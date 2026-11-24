class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            int gcd = 0;

            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = findGcd(gcd, nums[j]);

                long lcm = 1;
                for (int k = i; k <= j; k++) {
                    lcm = lcm / findGcd(lcm, nums[k]) * nums[k];
                }

                if (product == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private int findGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return (int) a;
    }
}