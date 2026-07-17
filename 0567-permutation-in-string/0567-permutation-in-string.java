class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();

        for(int i = 0; i< s1.length(); i++){
            char ch = s1.charAt(i);

            map1.put(ch,map1.getOrDefault(ch,0)+1);

        }

        HashMap<Character,Integer> map2 = new HashMap<>();
        
        int n = s1.length();
        int left = 0;

        for(int i = 0; i<s2.length(); i++){

            char ch = s2.charAt(i);

            map2.put(ch,map2.getOrDefault(ch,0)+1);


            if(i-left+1 == n){
                if(map1.equals(map2)) return true;
            


            char remove = s2.charAt(left);

            // reduce a count...

            map2.put(remove,map2.get(remove)-1);

            if(map2.get(remove)==0){
                map2.remove(remove);
            }

            left++;

            }



        
        }

        return false;
    }
}