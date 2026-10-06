class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return atMost(nums,goal) - atMost(nums,goal-1);
    }

    public static int atMost(int nums[], int goal){

        int left = 0;
        int count = 0;
        int sum = 0;

        if(goal < 0) return 0;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];

            while(sum > goal){
                sum -= nums[left++];
            }

            count += i - left+1;
        }

        return count;
    }
}