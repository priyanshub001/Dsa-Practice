class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> l = new ArrayList<>();

        int i = 0;

        while( i < nums.length){

            int correctidx = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= nums.length && 
            nums[i] != nums[correctidx]){

                swap(nums,i,correctidx);

            }
            else{
                i++;
            }
        }

        for(int k = 0; k<nums.length; k++){

            if(nums[k] != k+1){
                l.add(k+1);
            }
        }
        
        return l;
    }

    public static void swap(int nums[], int i , int j){

        int temp = nums[i];
        nums[i] = nums[j];

        nums[j] = temp;
    }
}