class Solution {
    public int numOfSubarrays(int[] arr) {
          
        int mod = 1000000007;

        int odd = 0;
        int even = 1; 

        int prefixSum = 0;
        long count = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum % 2 != 0) {

                count = (count + even) % mod;
                odd++;

            } else {

                count = (count + odd) % mod;
                even++;
            }
        }

        return (int) count;
    }
}