class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        
        int prefixmul[] = new int[n];
        int leftmul[] = new int[n];
        int rightmul[] = new int[n];

        

        leftmul[0] = 1;

        for(int i = 1; i<n; i++){

            leftmul[i] = leftmul[i-1] * nums[i-1];
        }


        rightmul[n-1] = 1;

        for(int i = n-2; i>= 0; i--){

            rightmul[i] = rightmul[i+1] * nums[i+1];
        }

        // for(int a : leftmul){
        //     System.out.println(a);
        // }

        for(int i = 0; i<n; i++){

            prefixmul[i] = leftmul[i] * rightmul[i];
        }



        return prefixmul;

    }
}