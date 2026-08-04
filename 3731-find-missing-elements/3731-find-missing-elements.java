class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        List <Integer > ans = new ArrayList();

        for(int n : nums){
            if(n > max){
                max = n;
            }
        }


        for(int n : nums){
            if(n < min){
                min = n;
            }
        }

        for(int n : nums){
            set.add(n);
        }

       for(int i = min; i<=max; i++){

            if(!set.contains(i)){
                ans.add(i);
            }
       }

        return ans;


    }
}