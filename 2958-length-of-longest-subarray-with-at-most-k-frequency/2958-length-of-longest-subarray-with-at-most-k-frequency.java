class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0; 
        int left = 0; 

        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            // if(map.get (nums[i]) <= k){
            //     count++;
            // }
           
            while(map.get(nums[i]) > k){

                    map.put(nums[left], map.get(nums[left])- 1);
                    left++;

                }

            
            count = Math.max(count, i - left+1);
        

        }

        return count;
        
    }
}