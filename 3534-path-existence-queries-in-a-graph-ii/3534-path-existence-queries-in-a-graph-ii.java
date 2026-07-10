class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
      int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] value = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }

        int[] right = new int[n];
        int r = 0;

        for (int i = 0; i < n; i++) {
            while (r + 1 < n && value[r + 1] - value[i] <= maxDiff)
                r++;
            right[i] = r;
        }

        int[] left = new int[n];
        int l = 0;

        for (int i = 0; i < n; i++) {
            while (value[i] - value[l] > maxDiff)
                l++;
            left[i] = l;
        }

        int LOG = 18;

        int[][] up = new int[LOG][n];
        int[][] down = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = right[i];
            down[0][i] = left[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
                down[k][i] = down[k - 1][down[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int s = pos[queries[qi][0]];
            int t = pos[queries[qi][1]];

            if (s == t) {
                ans[qi] = 0;
                continue;
            }

            if (s < t) {

                int cur = s;
                int steps = 0;

                for (int k = LOG - 1; k >= 0; k--) {
                    int nxt = up[k][cur];
                    if (nxt < t) {
                        cur = nxt;
                        steps += 1 << k;
                    }
                }

                if (cur < t) {
                    if (right[cur] == cur) {
                        ans[qi] = -1;
                    } else {
                        cur = right[cur];
                        steps++;
                        ans[qi] = (cur >= t) ? steps : -1;
                    }
                }

            } else {

                int cur = s;
                int steps = 0;

                for (int k = LOG - 1; k >= 0; k--) {
                    int nxt = down[k][cur];
                    if (nxt > t) {
                        cur = nxt;
                        steps += 1 << k;
                    }
                }

                if (cur > t) {
                    if (left[cur] == cur) {
                        ans[qi] = -1;
                    } else {
                        cur = left[cur];
                        steps++;
                        ans[qi] = (cur <= t) ? steps : -1;
                    }
                }
            }
        }

        return ans;
    }
}