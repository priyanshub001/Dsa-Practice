class Solution {
    public int minMoves(int[] nums) {

        int count = 0;

        int max = 0;

        for(int n : nums){

            max = Math.max(n,max);
        }

        for(int n : nums){

            while(n < max) {
                count++;
                n++;
            }
        }

        return count;
        
    }
}