class Solution {
    public int removeDuplicates(int[] nums) {
        
        int slow = 1;

        for(int i = 2; i < nums.length; i++){

            if(nums[i] != nums[slow-1]){
                slow++;
                nums[slow] = nums[i];
            }
        }

        return slow+1;


    }
}