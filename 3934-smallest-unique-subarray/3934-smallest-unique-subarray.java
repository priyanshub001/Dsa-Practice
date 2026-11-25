import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        Integer[] sa = new Integer[n];
        int[] rank = nums.clone();

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        for (int k = 1; k < n; k *= 2) {
            final int len = k;
            final int[] r = rank;

            Arrays.sort(sa, (a, b) -> {
                if (r[a] != r[b]) {
                    return Integer.compare(r[a], r[b]);
                }

                int x = a + len < n ? r[a + len] : -1;
                int y = b + len < n ? r[b + len] : -1;

                return Integer.compare(x, y);
            });

            int[] newRank = new int[n];

            for (int i = 1; i < n; i++) {
                int a = sa[i - 1];
                int b = sa[i];

                int x1 = rank[a];
                int x2 = a + len < n ? rank[a + len] : -1;

                int y1 = rank[b];
                int y2 = b + len < n ? rank[b + len] : -1;

                newRank[b] = newRank[a] +
                    ((x1 != y1 || x2 != y2) ? 1 : 0);
            }

            rank = newRank;

            if (rank[sa[n - 1]] == n - 1) {
                break;
            }

            if (k > n / 2) {
                break;
            }
        }

        int[] position = new int[n];
        int[] lcp = new int[n];

        for (int i = 0; i < n; i++) {
            position[sa[i]] = i;
        }

        int h = 0;

        for (int i = 0; i < n; i++) {
            int p = position[i];

            if (p == 0) {
                h = 0;
                continue;
            }

            int j = sa[p - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[p] = h;

            if (h > 0) {
                h--;
            }
        }

        int ans = n;

        for (int i = 0; i < n; i++) {
            int longest = lcp[i];

            if (i + 1 < n) {
                longest = Math.max(longest, lcp[i + 1]);
            }

            int remaining = n - sa[i];

            if (longest < remaining) {
                ans = Math.min(ans, longest + 1);
            }
        }

        return ans;
    }
}