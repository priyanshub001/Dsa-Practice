import java.util.HashSet;

public class longestsubstring {
    
    public static int longsubstring(String s){

        int maxLen=0;

       for(int i = 0; i < s.length(); i++){

            HashSet<Character> set = new HashSet<>();

            for(int j = i; j < s.length(); j++){

                char ch = s.charAt(j);

                if(set.contains(ch)){
                    break;
                }

                set.add(ch);

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }


        

        return maxLen;


    }
     public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(longsubstring(s));
    }
}
