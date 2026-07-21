class Solution {
    public int trap(int[] height) {
        
      int n = height.length;
      int leftmax[] = new int[n];
      int rightmax[] = new int[n];

      int left=0 , right = 0;

      for (int i = 0; i<n; i++){

        left = Math.max(left,height[i]);

        leftmax[i] = left;

      }

      for (int i = n-1; i>=0; i--){

        right = Math.max(right,height[i]);

        rightmax[i] = right;

      }

    //   for(int m : leftmax){
    //     System.out.println("left "+m);
    //   }

    //   for(int m : rightmax){
    //     System.out.println(m);
    //   }

    int formin[] = new int[n];
    

    for(int i  = 0; i<n; i++){
        formin[i] = Math.min(leftmax[i],rightmax[i]);
    }

    int sum = 0;

    for(int i = 0; i<n; i++){

        sum += formin[i] - height[i];
    }



      return sum;
    }
}