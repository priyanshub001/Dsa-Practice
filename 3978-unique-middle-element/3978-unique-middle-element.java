class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n: nums){

            map.put(n,map.getOrDefault(n,0)+1);
        }

        int m = nums[nums.length/2];

        return map.get(m)==1;
        
    }
}