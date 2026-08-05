class Solution {
    public int smallestRepunitDivByK(int k) {
        
    //     int n = k;
    //     int check = 1;
    //     int res = 0;
    //     int a = Integer.MAX_VALUE;

    //     if(n % 2 == 0 || n % 5 == 0){

    //         return -1;

    //     } else{


    //         while(check < a){

        

    //         if(check % k == 0){

    //              res = len(check);

    //              return res;


            
    //         }else{

    //            check = check *10 + 1;

    //         }

    //      }

    //   }

    //     return res;
        
    // }

    // static int len(int n){

    //     int count = 0;

    //     while(n > 0){
           
    //        n/=10;
    //        count++;
            
    //     }

    //     System.out.print(count);

    //     return count;

    // Impossible cases

    
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int remainder = 0;

        for (int length = 1; length <= k; length++) {

            remainder = (remainder * 10 + 1) % k;

            if (remainder == 0) {
                return length;
            }
        }

        return -1;
    }
}