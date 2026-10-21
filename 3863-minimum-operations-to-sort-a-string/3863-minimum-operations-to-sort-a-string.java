class Solution {
    public int minOperations(String s) {
          int n = s.length();

        int[] freq = new int[26];
        char min = 'z';
        char max = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
        }

        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;
        if (n == 2) return -1;

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min) {
            if (freq[max - 'a'] == 1 && freq[min - 'a'] == 1) {
                return 3;
            }
        }

        return 2;
    }
}