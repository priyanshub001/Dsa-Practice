class Solution {
    public long countSubarrays(int[] nums, long k) {

        long count = 0;
        int len = 0;
        long sum = 0;
        int left = 0;

        for(int i = 0; i<nums.length; i++){

            sum += nums[i];
            len++;

           

            while(sum * len >= k){
                sum -= nums[left];
                left++;
                len --;
            }

            count += len;
        }

        return count;
        
    }
}