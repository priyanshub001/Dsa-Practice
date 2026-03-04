public class max_num_vowel {
    
    public static int  maxVowel(String s, int k){

        int count =0;
        int max=0;

        for (int i=0; i<k; i++){
            if (isvowel(s.charAt(i))) {
                count++;
            }
        }

        max = count;

        for(int i=k; i<s.length(); i++){
            if (isvowel(s.charAt(i))) {
                count++;
            }

            if (isvowel(s.charAt(i-k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;

    }

    public static boolean isvowel(char c){
        return c=='a' || c=='e' || c== 'i' || c== 'o'|| c=='u';
    }


    public static void main(String[] args) {
        String s = "abciiidef";
        int k=3;

        System.out.println(maxVowel(s, k));
    }
}
