class Solution {
    public long sumAndMultiply(int n) {

        long a = 0,sum = 0,x=0,ans=0;

        while(n > 0){
            long rem = n%10;
            if(rem != 0){
                a = a*10+rem;
            }

            n/=10;
        }
    

        while(a > 0){
            long rem = a%10;
            if(rem != 0){
                x = x*10+rem;
            }

            a/=10;
        }

        ans = x;




        while( x> 0){
            long rem = x%10;

            sum += rem;

            x/=10;
        }

        return ans*sum;
        
    }
}