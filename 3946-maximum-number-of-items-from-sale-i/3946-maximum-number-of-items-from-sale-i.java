class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
           int n = items.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int free = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free++;
                }
            }

            arr[i][0] = items[i][1];
            arr[i][1] = free + 1;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1000000);
        dp[0] = 0;

        int[] current = new int[budget + 1];

        int ans = 0;
        int index = 0;

        while (index < n) {
            int price = arr[index][0];

            Arrays.fill(current, -1000000);

            while (index < n && arr[index][0] == price) {
                int value = arr[index][1];

                for (int j = budget; j >= price; j--) {
                    current[j] = Math.max(
                        current[j],
                        Math.max(
                            current[j - price] + value,
                            dp[j - price] + value
                        )
                    );

                    dp[j] = Math.max(dp[j], dp[j - price] + value);
                }

                index++;
            }

            for (int j = 0; j <= budget; j++) {
                if (current[j] >= 0) {
                    ans = Math.max(
                        ans,
                        current[j] + (budget - j) / price
                    );
                }
            }
        }

        return ans;
    }
}