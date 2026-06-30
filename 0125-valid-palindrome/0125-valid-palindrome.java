class Solution {
    public boolean isPalindrome(String s) {
    //     String r = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

    //     String rev = new StringBuilder(r).reverse().toString();

    //    if (rev.equals(r)) {
    //     return true;
    // }

        
    //     return false;

//     int left = 0;
// int right = s.length() - 1;

// while (left < right) {

//     while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
//         left++;
//     }

//     while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
//         right--;
//     }

//     if (Character.toLowerCase(s.charAt(left)) != 
//         Character.toLowerCase(s.charAt(right))) {
//         return false;
//     }

//     left++;
//     right--;
// }

// return true;

// s = s.trim();

// s= s.toLowerCase();

s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();

String rev = new StringBuilder(s).reverse().toString();

if(rev.equals(s)){
    return true;
}



return false;


    }
}