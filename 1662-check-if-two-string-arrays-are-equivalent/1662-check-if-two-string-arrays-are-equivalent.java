class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        // String[] res = new String[word1.length()+word2.length()];

        String p = "";
        
        for(int i=0; i< word1.length; i++){

            p=String.join("",word1);

            
        }

        String k = "";
        
        for(int i=0; i< word2.length; i++){

            k=String.join("",word2);

   
        }

        if(p.equals(k)){

            return true;
        }


        return false;
    }
}