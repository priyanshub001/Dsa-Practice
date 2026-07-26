class Solution {
    public int maximumProduct(int[] nums) {
        
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        int thirdlargest = Integer.MIN_VALUE;


        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;


        for(int i = 0; i<nums.length; i++){

            int n = nums[i];
            if(n > largest ){
                thirdlargest = secondlargest;
                secondlargest = largest;
                largest = n;
            }

             else   if( n > secondlargest){
                thirdlargest = secondlargest;
                secondlargest = n;
            }

            else if(n > thirdlargest){
                thirdlargest = n;
            }

             if (n <= smallest) {
                secondSmallest = smallest;
                smallest = n;
            } else if (n < secondSmallest) {
                secondSmallest = n;
            }
        }


        

        return Math.max(
                largest * secondlargest * thirdlargest,
                largest * smallest * secondSmallest
        );
    } 
}