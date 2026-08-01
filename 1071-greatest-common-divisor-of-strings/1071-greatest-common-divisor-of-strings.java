class Solution {
    public String gcdOfStrings(String str1, String str2) {

        String a = str1+str2;
        String b = str2+str1;

        int p = str1.length();
        int k = str2.length();

        if(!a.equals(b)) return "";

       int res = gcd(p,k);

       return str1.substring(0,res);
        
        
    }

    public static int gcd(int a, int b){

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


}