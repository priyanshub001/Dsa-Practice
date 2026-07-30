class Solution {
    public int pivotIndex(int[] nums) {

        int total = 0;

        for(int n : nums){

            total += n;
        }

        int leftsum = 0;
        int rightsum = 0;

        for(int i = 0; i<nums.length; i++){

           

            rightsum = total - leftsum - nums[i];

            if(leftsum == rightsum) return i;

             leftsum += nums[i];
        }


        return -1;


        
    }
}