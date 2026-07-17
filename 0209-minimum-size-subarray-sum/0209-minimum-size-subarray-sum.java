class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;

        int minlen = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length; i++){

            sum += nums[i];

            while(sum >= target){

                int len = i-left+1;

                minlen = Math.min(len,minlen);

                sum -= nums[left];
                left++;

                

            }

           
        }

        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}