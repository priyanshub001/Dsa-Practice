class Solution {
    public int firstMissingPositive(int[] nums) {

      int  i = 0;

        while(i < nums.length){

            int correctidx = nums[i] - 1;

           if (nums[i] > 0 &&
                nums[i] <= nums.length &&
                nums[i] != nums[correctidx]) 
                
            {
              
              swap(nums,i,correctidx);

            } else{
                i++;
            }
        }


        for (int p = 0; p<nums.length; p++){

            int expected = p+1;

            if(nums[p] != expected){
                return p+1;
            }
        }

        
        return nums.length + 1;

    
        
    }

    public static void swap(int nums[], int i , int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}