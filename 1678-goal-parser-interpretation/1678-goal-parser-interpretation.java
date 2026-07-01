class Solution {
    public String interpret(String command) {
        String res = "";

        for(int i =0; i< command.length(); i++){

            char ch = command.charAt(i);

            if(ch == 'G'){
                res += "G";
            } else if(ch == '(' &&  command.charAt(i+1)== ')' ){
                res += "o";
                i++;
            } else{
                res += "al";
                i+=3;
            }
        }
        return res;
    }
}