class Solution {
    public String mergeAlternately(String word1, String word2) {
        
    char[] res = new char[word1.length() + word2.length()];

       int k = 0;
       int i = 0;
       int j = 0;

       while(i < word1.length() && j <word2.length()){

            res[k++] = word1.charAt(i++);
            res[k++] = word2.charAt(j++);
       }

       while (i < word1.length()){

        res[k++]= word1.charAt(i++);
       }

       while(j< word2.length()){

        res[k++] = word2.charAt(j++);
       }

       return String.valueOf(res);





     

    }
}