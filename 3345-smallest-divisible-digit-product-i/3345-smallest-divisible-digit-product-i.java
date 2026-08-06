class Solution {
    public int smallestNumber(int n, int t) {

        int p = 1;
        int s  = Integer.MAX_VALUE;

        for(int i = n; i <s; i++){

            p = 1;

            int a = i;

             while (a > 0){

            int rem = a % 10;
            p *= rem;
            a /= 10;
         }

         if(p % t == 0){
            return i;
         }
         

        }
        
        return -1;
    }
}