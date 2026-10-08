class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int n : nums){
            set.add(n);
        }

        for(int n : set){

            if(!set.contains(n-1)){
                int count = 1;
                while(set.contains(n+1)){
                    count++;
                    n++;

                }
                    max  = Math.max(count,max);
            }
        }

        return max;
        
    }
}