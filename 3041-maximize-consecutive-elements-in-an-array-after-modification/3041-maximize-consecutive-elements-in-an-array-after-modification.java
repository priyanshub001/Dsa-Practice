class Solution {
    public int maxSelectedElements(int[] nums) {
       Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int num : nums) {
            int next = dp.getOrDefault(num, 0) + 1;
            int current = dp.getOrDefault(num - 1, 0) + 1;

            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), next));
            dp.put(num, Math.max(dp.getOrDefault(num, 0), current));

            ans = Math.max(ans, Math.max(dp.get(num), dp.get(num + 1)));
        }

        return ans;
        }
}