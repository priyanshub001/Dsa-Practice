class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int sum = 0;
        int maxsum = 0;

        for(int i = 0; i < accounts.length; i++){

            for(int j = 0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }


            maxsum = Math.max(sum , maxsum);
            sum = 0;

        }


        return maxsum;
    }
}