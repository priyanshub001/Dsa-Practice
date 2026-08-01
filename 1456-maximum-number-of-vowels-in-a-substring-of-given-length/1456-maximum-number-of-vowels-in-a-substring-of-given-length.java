class Solution {
    public int maxVowels(String s, int k) {

        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < k; i++){

            char ch = s.charAt(i);

            if(isVowel(ch)) count++;
        }

        max = count;

        for(int i = k; i <s.length(); i++){


            char remove = s.charAt(i-k);

            if(isVowel(remove)) count--;

            char add = s.charAt(i);

            if(isVowel(add)) count++;

            max = Math.max(max,count);



        }

        


        return max;
        
    }

    public static boolean isVowel(char ch){

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        return true;
        }

        return false;
    }

}