class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int s = 0;
        int e = nums.length -1;
        int res[] = new int[nums.length]; 
        int even = 0;
        int odd = nums.length-1;

        while(s <=e){
            if(nums[s]%2==0){
                res[even] = nums[s];
                
                even++;
            }else{
                res[odd] = nums[s];
                odd--;
            }

            s++;
        }

        return res;
    }
}