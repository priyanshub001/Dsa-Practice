class Solution {
    public int maxProduct(int n) {

        // int k = n;
        // int p = n;
        // int max = Integer.MIN_VALUE;
        

        // while(k > 0){
        //     int rem = k %10;
        //     max = Math.max(rem,max);
        //     k/=10;

        // }


        String s = String.valueOf(n);

        int nums[] = new int[s.length()];

        for(int i = 0; i<s.length(); i++){

            nums[i] = s.charAt(i)-'0';
        }


        int last = Integer.MIN_VALUE;
        int lastsecond = Integer.MIN_VALUE;

        for(int p: nums){

            if(p > last){

                lastsecond = last;
                last = p;
            } 

            else if (p > lastsecond ) {
                lastsecond = p;
            }
         }
        
        return last*lastsecond;

        
    }
}