class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        return dfs(0, x, coins, 1);
    }

    private long dfs(int index, long x, int[] coins, long lcm) {
        if (lcm > x) {
            return 0;
        }

        long result = 0;

        for (int i = index; i < coins.length; i++) {
            long newLcm = lcm(lcm, coins[i]);

            if (newLcm <= x) {
                result += x / newLcm - dfs(i + 1, x, coins, newLcm);

                if (result >= x) {
                    return result;
                }
            }
        }

        return result;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}