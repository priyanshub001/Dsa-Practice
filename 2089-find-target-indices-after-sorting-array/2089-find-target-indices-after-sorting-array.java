class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

         Arrays.sort(nums);

         HashMap<Integer , Integer> map = new HashMap<>();

         for(int n : nums){

            map.put(n, map.getOrDefault(n,0)+1);
         }

         int k = 0;
         

            int j = 0;

        List<Integer> l = new ArrayList<>();

         for(int i = 0; i < nums.length; i++){

            if(nums[i] == target){
                j=i;
                k = map.get(target);
                break;
            }


         }

         while(k > 0){
            l.add(j);
            k--;
            j++;
         }
        
        return l;
    }
}