class Solution {
    public int longestSubsequence(int[] nums) {
        
        int len = nums.length;
        int zerocount = 0;
        int ans = 0;
        for(int n : nums){

            ans ^= n;

            if(n == 0) zerocount++;


        }

        if(ans != 0) return len;

        if(zerocount == len) return 0;


        return len-1;
    }
}