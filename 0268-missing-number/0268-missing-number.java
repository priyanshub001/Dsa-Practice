class Solution {
    public int missingNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        int max = nums.length;

        for(int n : nums) set.add(n);

        for(int i = 0; i <= max; i ++){
            if(!set.contains(i)) return i;
        }

        return 0;
    }
}