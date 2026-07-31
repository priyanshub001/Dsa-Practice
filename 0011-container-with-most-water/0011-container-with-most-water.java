class Solution {
    public int maxArea(int[] height) {
        
        int l = 0;
        int r = height.length-1;
        int ans = 0, max = 0;

        while (l < r){

            int width = r-l;
            int hght = Math.min(height[l],height[r]);

            ans = width * hght;
            max = Math.max(ans,max);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }

        }

        return max;
        
    }
}