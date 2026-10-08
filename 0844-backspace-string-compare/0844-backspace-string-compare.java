class Solution {
    public boolean backspaceCompare(String s, String t) {

       int sr= s.length()-1;
       int tr = t.length()-1;


       int skips = 0;
       int skipt = 0;


       while(sr >= 0 || tr >=0){


            while(sr >= 0){

                if(s.charAt(sr)=='#'){
                    skips++;
                    sr--;
                }

                else if(skips > 0){
                    skips --;
                    sr--;
                }else{
                    break;
                }
            }

            while(tr >= 0){

                if(t.charAt(tr) == '#'){
                    skipt++;
                    tr--;
                }

                else if(skipt> 0){
                    skipt--;
                    tr--;
                }else{
                    break;
                }
            }

            if(sr >= 0 && tr >= 0){
            if(s.charAt(sr) != t.charAt(tr)) return false;

            sr--;
            tr--;

            }

              else if(sr >= 0 || tr >=0) return false;

       }

      

        return true;
       
       
        
    }
}