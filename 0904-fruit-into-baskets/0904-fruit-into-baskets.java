class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer , Integer> map = new HashMap<>();
        int l = 0;
        int maxlen = 0;

        for(int i = 0; i < fruits.length; i++){
            
            map.put(fruits[i] , map.getOrDefault(fruits[i] , 0)+1 );

            while(map.size() > 2) {

                int rem = fruits[l++];
                map.put(rem , map.get(rem) -1);
                if(map.get(rem) == 0){
                    map.remove(rem);
                }
            }


            int len = i - l+1;
            maxlen = Math.max(len , maxlen);
        }

        return maxlen;



          
    }
}