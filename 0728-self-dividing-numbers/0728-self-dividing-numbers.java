class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> ans = new ArrayList<>();
        int pkk = 0;

        for(int i = left; i <= right; i++){

             pkk = check(i);

             if(pkk != 0){

             

            ans.add(pkk);

             }
        }

        return ans;
        
    }

    static int check(int n){
        int b = n;
        int a = n;
        int count = 0;
        int len = 0;
        int k = 0; 


        while(b > 0){

            b /= 10;
            len++;
        }

        while(a > 0){

            int rem = a % 10;

            if(rem != 0 && n % rem == 0){
                count++;
            }

            a /=10;
        }

        if (count == len){
            k = n;
        }



         
        return k;

        
    }
}