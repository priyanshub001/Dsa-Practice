class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        

        return atMost(nums, k) - atMost(nums,k-1);
    }

    public static int atMost(int nums[], int k){

        if(k < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;

        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);

            while(map.size() > k){

                int rem = nums[left++];

                map.put(rem,map.get(rem)-1);

                if(map.get(rem) == 0){
                    map.remove(rem);
                }
            }

            count += i - left+1;
        }

        return count;
    }
}