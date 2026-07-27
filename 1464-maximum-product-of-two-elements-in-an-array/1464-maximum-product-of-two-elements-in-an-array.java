class Solution {
    public int maxProduct(int[] nums) {

        int largest = 0;
        int secondlargest = 0;

        for(int n : nums){

            if(n > largest){
                secondlargest = largest;
                largest = n;

            } else if( n > secondlargest){
                secondlargest = n;
            }
        }



        // System.out.println(largest);

        return (secondlargest -1) * (largest - 1);
        
    }
}