class Solution {
    public int longestSubarray(int[] nums) {
        // int left = 0;
        // int zeroCount = 0;
        // int maxLen = 0;

        // for (int right = 0; right < nums.length; right++) {

        //     if (nums[right] == 0) {
        //         zeroCount++;
        //     }

        //     while (zeroCount > 1) {
        //         if (nums[left] == 0) {
        //             zeroCount--;
        //         }
        //         left++;
        //     }

        //     maxLen = Math.max(maxLen, right - left);
        // }

        // return maxLen;

        // int zerocount = 0;
        // int left = 0;
        // int ans = 0;


        // for(int i = 0; i<nums.length; i++){

        //     if(nums[i]==0) zerocount++;

        //     while(zerocount > 1){

        //         if(nums[left]==0) zerocount--;
              
        //        left++; 
        //     }



        //     ans = Math.max(ans,i-left);



        // }

        // return ans;

        int left = 0;
        int zero = 0;
        int size = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i]==0) zero++;

            while(zero > 1){

                if(nums[left] == 0) zero--;

                left++;
            }

            size = Math.max(size,i-left);





        }

        return size;
    }
}