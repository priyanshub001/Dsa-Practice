class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int k = 0;

        for(int i = 0; i<s.length(); i++){

            char ch = s.charAt(i);

            while(set.contains(ch)){

                
                set.remove(s.charAt(k));
                k++;
            

            }

            set.add(ch);

            int len = set.size();
            maxlen = Math.max(len,maxlen);
        }

        return maxlen;


    }
}