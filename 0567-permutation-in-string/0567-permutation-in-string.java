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
        int k = s1.length();

        for(int i = 0; i<k; i++){
            char ch = s2.charAt(i);

            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        if(map1.equals(map2)) return true;

        for(int i = k; i<s2.length(); i++){

            char add = s2.charAt(i);

            map2.put(add, map2.getOrDefault(add, 0) + 1);

            char rem = s2.charAt(i-k);

            map2.put(rem, map2.get(rem) - 1);

            if(map2.get(rem)==0){
                map2.remove(rem);
            }


            if(map2.equals(map1)) return true;



        }
       
        

        return false;


    }
}