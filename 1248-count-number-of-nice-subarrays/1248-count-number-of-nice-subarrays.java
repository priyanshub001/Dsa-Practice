class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atMost(nums, k) - atMost(nums,k-1);
    }

    public static int atMost(int nums[], int k){

        int count = 0;
        int a = 0;
        int left = 0;


        for(int i = 0; i < nums.length; i++){

            if(nums[i]%2 != 0){
                a++;
            }

            while(a > k){

                 if(nums[left] % 2 != 0){
                    a--;
            }
                left++;
            }

            count += i - left +1;

        }
        return count;
    }
}