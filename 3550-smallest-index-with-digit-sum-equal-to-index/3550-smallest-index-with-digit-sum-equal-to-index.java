class Solution {
    public int smallestIndex(int[] nums) {

   

        for(int i = 0; i < nums.length; i++){

            int a = nums[i];
            int sum = 0;

            while(a > 0){
                int rem = a % 10;
                sum += rem;
                a/=10;
            }

            if(sum == i) return i;
        }

        return -1;
        
    }
}