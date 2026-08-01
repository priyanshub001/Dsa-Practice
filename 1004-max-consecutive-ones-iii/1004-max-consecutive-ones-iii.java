class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zero = 0;
        int size = 0;

        for(int i = 0; i<nums.length; i++){

            if(nums[i] == 0) zero++;

            while(zero > k){

                if(nums[left] == 0) zero--;

                left++;
            }
        size = Math.max(size,i-left+1);
        }

        return size;

        
    }
}