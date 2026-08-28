class Solution {
    public String lexPalindromicPermutation(String s, String target) {
          int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        char[] left = new char[halfLen];

        for (int i = 0; i < halfLen; i++) {
            int x = target.charAt(i) - 'a';

            if (half[x] > 0) {
                left[i] = target.charAt(i);
                half[x]--;
            } else {
                return findAnswer(target, left, half, i, middle);
            }
        }

        String ans = build(left, middle);

        if (ans.compareTo(target) > 0) {
            return ans;
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            int current = left[i] - 'a';
            half[current]++;

            for (int j = current + 1; j < 26; j++) {
                if (half[j] > 0) {
                    half[j]--;

                    left[i] = (char) ('a' + j);

                    int pos = i + 1;

                    for (int k = 0; k < 26; k++) {
                        while (half[k] > 0) {
                            left[pos++] = (char) ('a' + k);
                            half[k]--;
                        }
                    }

                    return build(left, middle);
                }
            }
        }

        return "";
    }

    private String findAnswer(String target, char[] left, int[] half,
                              int pos, char middle) {

        int x = target.charAt(pos) - 'a';

        for (int j = x + 1; j < 26; j++) {
            if (half[j] > 0) {
                left[pos] = (char) ('a' + j);
                half[j]--;

                int p = pos + 1;

                for (int k = 0; k < 26; k++) {
                    while (half[k] > 0) {
                        left[p++] = (char) ('a' + k);
                        half[k]--;
                    }
                }

                return build(left, middle);
            }
        }

        for (int i = pos - 1; i >= 0; i--) {
            int current = left[i] - 'a';
            half[current]++;

            for (int j = current + 1; j < 26; j++) {
                if (half[j] > 0) {
                    half[j]--;

                    left[i] = (char) ('a' + j);

                    int p = i + 1;

                    for (int k = 0; k < 26; k++) {
                        while (half[k] > 0) {
                            left[p++] = (char) ('a' + k);
                            half[k]--;
                        }
                    }

                    return build(left, middle);
                }
            }
        }

        return "";
    }

    private String build(char[] left, char middle) {
        StringBuilder sb = new StringBuilder();

        for (char c : left) {
            sb.append(c);
        }

        if (middle != 0) {
            sb.append(middle);
        }

        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}