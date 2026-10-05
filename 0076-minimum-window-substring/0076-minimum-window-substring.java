class Solution {
    public String minWindow(String s, String t) {
        

        HashMap<Character , Integer> maps = new HashMap<>();
        HashMap<Character , Integer> mapt = new HashMap<>();

        for(char ch : t.toCharArray()){

            mapt.put(ch , mapt.getOrDefault(ch , 0) +1);

        }

        int formed = 0;
        int l = 0;
        int minlen = Integer.MAX_VALUE;
        String res = "";

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            maps.put(ch , maps.getOrDefault(ch , 0) +1);

            if(mapt.containsKey(ch) && mapt.get(ch).equals(maps.get(ch))){

                formed++;
            }

            while(formed == mapt.size()){
               
               int len =  i - l + 1 ;

               if(minlen > len){
                minlen = len;
                res = s.substring(l,i+1);
               }



                char rem = s.charAt(l);
                maps.put(rem , maps.get(rem)-1);

               if(mapt.containsKey(rem) && maps.get(rem) < mapt.get(rem)){

                formed--;
               }

               l++;

            }

        }

        System.out.print(minlen);

        return res;



    }
}