class Solution {

    int[] gcd;
    public long gcdSum(int[] nums) {

        gcd = new int[nums.length];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){

            max  = Math.max(nums[i],max);

          gcd[i] =  prefixgcd(nums[i],max);
        }

        Arrays.sort(gcd);

        long sum = 0;

        int l = 0;
        int r = gcd.length-1;

        while(l<r){
            sum+=prefixgcd(gcd[l],gcd[r]);   
            l++;
            r--;  
        }


        return sum;

  
    }

    static int prefixgcd(int a,int b){
     while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }

    return a;

    }
}