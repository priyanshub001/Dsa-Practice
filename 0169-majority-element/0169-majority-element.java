class Solution {
    public int majorityElement(int[] nums) {
       
     HashMap<Integer,Integer> map = new HashMap<>();

     for(int n : nums){
        map.put(n,map.getOrDefault(n,0)+1);
     }

     int target = nums.length/2;

     for(int n : map.keySet()){

        if(map.get(n)>target){
            return n;
        }
     }


     return -1;




    }
}