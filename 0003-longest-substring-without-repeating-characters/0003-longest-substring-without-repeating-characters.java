class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int len = 0;
        int left = 0;


        for(char ch : s.toCharArray()){

            while(set.contains(ch)){
                set.remove(s.charAt(left++));
                
                
            }

            set.add(ch);
            len = set.size();

            
            maxLen = Math.max(maxLen,len);
        }

        return maxLen;
    }
}