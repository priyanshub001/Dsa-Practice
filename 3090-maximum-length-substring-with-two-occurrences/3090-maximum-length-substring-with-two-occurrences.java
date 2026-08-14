class Solution {
    public int maximumLengthSubstring(String s) {

        int len = 0;
        int left = 0;

        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0)+1);


            while(map.get(ch) > 2){

                


                char leftchar = s.charAt(left);

                map.put(leftchar,map.get(leftchar) - 1);

                left++;

            }

                int count = i - left + 1;
                len = Math.max(count,len);



        }

        return len;
        
    }
}