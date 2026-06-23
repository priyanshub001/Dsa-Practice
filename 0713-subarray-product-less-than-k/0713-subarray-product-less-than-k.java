class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    //     if(k<=1){
    //         return 0;
    //     }
    //     int prod=1;
    //     int left=0;
    //     int right=0;
    //     int n=nums.length;
    //     int count=0;
        
    //     while(right <n)
    //     {
    //         prod*=nums[right];

    //         while(prod>=k){

    //             prod/=nums[left];
    //             left++;

    //         }
    //         count+=right-left+1;
    //         right++;
    //     }
    //     return count;

if (k <= 1) return 0;

    int l = 0;
    int r = 0;

    int p = 1;
    int count = 0;

    int n = nums.length-1;

    while (r <= n){

        p *= nums[r];

        while(p >= k){
         p /= nums[l];
            l++;
        }

        count += r-l+1;
        r++;


    }

    return count;
    
    
    
    
    
    }



}