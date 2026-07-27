class Solution {
    public int[] findErrorNums(int[] nums) {

        int i = 0;
        int res[] = new int[2];

        while (i < nums.length){

            int correctidx = nums[i]-1;

            if(nums[correctidx] != nums[i]){

                swap(nums,i,correctidx);
            }else{
                i++;
            }
        }

        for(int k = 0; k <nums.length; k++){

            int expected = k+1;
        

            if(nums[k] != expected){
                res[0] = nums[k];
                res[1] = expected ;
            }
        }

        return res;
        
    }

    public static void swap(int nums[], int i , int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}