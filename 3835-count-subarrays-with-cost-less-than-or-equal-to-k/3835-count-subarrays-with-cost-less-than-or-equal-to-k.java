class Solution {
    public long countSubarrays(int[] nums, long k) {

         Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int l = 0;
        long ans = 0;

        for (int r = 0; r < nums.length; r++) {

            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] <= nums[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(r);

            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] >= nums[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);

            while (l <= r &&
                   (long)(nums[maxDeque.peekFirst()] -
                          nums[minDeque.peekFirst()]) *
                   (r - l + 1) > k) {

                if (maxDeque.peekFirst() == l) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == l) {
                    minDeque.pollFirst();
                }

                l++;
            }

            ans += (r - l + 1);
        }

        return ans;
        
    }
}