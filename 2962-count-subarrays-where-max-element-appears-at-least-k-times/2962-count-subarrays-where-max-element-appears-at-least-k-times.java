class Solution {
    public long countSubarrays(int[] nums, int k) {
        
       int max = nums[0];
       int count = 0;

       for(int n : nums){

            if(n > max){
                max = n;
            }
       }

       for (int n : nums){

        if(n == max) count++;
       }

       if(count < k) return 0;

       int left = 0;
       int flag = 0;

       int len = nums.length;
       long ans = 0;


       for(int i = 0; i< nums.length; i++){

            if (nums[i] == max){
                flag++;
            }

            while (flag >= k){
                ans += len - i;

                if(nums[left] == max){
                    flag--;
                }

                left++;


            }


       }



       return ans;
    }
}