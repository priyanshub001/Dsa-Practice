class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> kp = new HashMap<>();

        for(char ch : s.toCharArray()){

            kp.put(ch,kp.getOrDefault(ch,0)+1);
        }

        for(int i = 0; i<s.length(); i++){

            char ch = s.charAt(i);

            int k =  kp.get(ch);

            if(k == 1) return i;

            
        }

        return -1;


    }
}