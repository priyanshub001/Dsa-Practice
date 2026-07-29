class Solution {

     static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
     
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        String mid = "";

        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];

            if ((freq[i] & 1) == 1)
                mid = "" + (char) ('a' + i);
        }

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder first = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (half[ch] == 0)
                    continue;

                half[ch]--;

                long ways = countWays(half, halfLen - pos - 1);

                if (ways >= k) {
                    first.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    half[ch]++;
                }
            }
        }

        String second = new StringBuilder(first).reverse().toString();

        return first.toString() + mid + second;
    }

    private long countWays(int[] cnt, int total) {

        long ans = 1;

        int remaining = total;

        for (int i = 0; i < 26; i++) {

            int c = cnt[i];

            if (c == 0)
                continue;

            ans *= combLimited(remaining, c);

            if (ans > LIMIT)
                ans = LIMIT;

            remaining -= c;
        }

        return ans;
    }

    private long combLimited(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {

            res = res * (n - r + i) / i;

            if (res > LIMIT)
                return LIMIT;
        }

        return res;
    }
}