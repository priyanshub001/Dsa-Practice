class Solution {
    public int maximumLengthSubstring(String s) {

        // int len = 0;
        // int left = 0;

        // HashMap<Character , Integer> map = new HashMap<>();

        // for(int i = 0; i < s.length(); i++){

        //     char ch = s.charAt(i);

        //     map.put(ch, map.getOrDefault(ch, 0)+1);


        //     while(map.get(ch) > 2){

                


        //         char leftchar = s.charAt(left);

        //         map.put(leftchar,map.get(leftchar) - 1);

        //         left++;

        //     }

        //         int count = i - left + 1;
        //         len = Math.max(count,len);



        // }

        // return len;

        int pk[] = new int[26];
        int left = 0;
        int maxlen = 0;

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            pk[ch - 'a']++;

            while(pk[ch - 'a'] > 2){
                char leftchar = s.charAt(left);

                pk[leftchar - 'a'] --;
                left++;
            }

            int len = i - left +1;

            maxlen = Math.max(len,maxlen);
        }


        return maxlen;
    }
}