class Solution {
    public boolean sumGame(String num) {
        
        int left = 0, right = 0;
        int qLeft = 0, qRight = 0;
        int n = num.length();

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') qLeft++;
            else left += num.charAt(i) - '0';

            if (num.charAt(n - 1 - i) == '?') qRight++;
            else right += num.charAt(n - 1 - i) - '0';
        }

        if ((qLeft + qRight) % 2 != 0) return true;

        int diff = left - right;
        int qDiff = qLeft - qRight;

        return diff != -qDiff * 4.5;
    }
}