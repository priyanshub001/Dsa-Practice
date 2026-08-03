class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;

        for(char ch : s.toCharArray()){

            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            int len = set.size();

            maxlen = Math.max(len,maxlen);
            

        }

        return maxlen;
        
    }
}