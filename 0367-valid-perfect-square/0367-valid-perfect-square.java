class Solution {
    public boolean isPerfectSquare(int num) {
        
        int l = 0; 
        int r = num;

        while(l <= r){

            long mid = l + (r-l) / 2;
            long ans = mid * mid;

            if(ans == num){
                return true;

            }else if(ans < num){
                l = (int)mid+1;
            }else{
                r = (int) mid-1;
            }
        }

        return false;
    }
}