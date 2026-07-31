class Solution {
    public int maxOperations(int[] nums, int k) {

        int count = 0;
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length-1;

        while(l < r){

            int sum = nums[l] + nums[r];

            if(sum == k){
                l++;
                r--;
                count++;

            } else if(sum > k){
                r--;
            }
            else{
                l++;
            }
        }

        return count;
        

    }
}