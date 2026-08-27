class Solution {
    public String lexGreaterPermutation(String s, String target) {
         int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        char[] ans = new char[target.length()];

        for (int i = 0; i < target.length(); i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] > 0) {
                ans[i] = target.charAt(i);
                cnt[x]--;
            } else {
                for (int j = x + 1; j < 26; j++) {
                    if (cnt[j] > 0) {
                        ans[i] = (char) ('a' + j);
                        cnt[j]--;

                        int p = i + 1;
                        for (int k = 0; k < 26; k++) {
                            while (cnt[k] > 0) {
                                ans[p++] = (char) ('a' + k);
                                cnt[k]--;
                            }
                        }

                        return new String(ans);
                    }
                }

                for (int j = i - 1; j >= 0; j--) {
                    cnt[ans[j] - 'a']++;

                    int cur = ans[j] - 'a';

                    for (int k = cur + 1; k < 26; k++) {
                        if (cnt[k] > 0) {
                            ans[j] = (char) ('a' + k);
                            cnt[k]--;

                            int p = j + 1;
                            for (int x2 = 0; x2 < 26; x2++) {
                                while (cnt[x2] > 0) {
                                    ans[p++] = (char) ('a' + x2);
                                    cnt[x2]--;
                                }
                            }

                            return new String(ans);
                        }
                    }
                }

                return "";
            }
        }

        for (int i = target.length() - 1; i >= 0; i--) {
            cnt[ans[i] - 'a']++;

            int cur = ans[i] - 'a';

            for (int j = cur + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    ans[i] = (char) ('a' + j);
                    cnt[j]--;

                    int p = i + 1;
                    for (int k = 0; k < 26; k++) {
                        while (cnt[k] > 0) {
                            ans[p++] = (char) ('a' + k);
                            cnt[k]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}