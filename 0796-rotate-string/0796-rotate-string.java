class Solution {
    public boolean rotateString(String s, String goal) {


        if(s.length() != goal.length()){
            return false;
        }

        String tamanna = s+s;

        return tamanna.contains(goal);
        
    }
}