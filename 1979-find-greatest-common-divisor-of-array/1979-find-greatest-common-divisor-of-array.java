class Solution {
    public int findGCD(int[] nums) {

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int n : nums) {
            int mx = n;
            int mn = n;

            max = Math.max(mx,max);
            min = Math.min(mn,min);
        }
        System.out.println(max);
        System.out.println(min);
        
        int res = gcd(min,max);

        return res;
    }

    static int gcd(int a, int b){

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }

    
}