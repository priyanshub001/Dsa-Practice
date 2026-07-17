class Solution {
    public int characterReplacement(String s, int k) {

        int maxfrq = 0;
        int left = 0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){

            char ch  = s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0)+1);

            maxfrq = Math.max(maxfrq,map.get(ch));

            while((i-left+1 )- maxfrq > k){

                char remove = s.charAt(left);
                map.put(remove, map.get(remove) - 1);

                left++;

            }
        
                ans = Math.max(i-left+1,ans);

            

        }


            return ans;


    }
}