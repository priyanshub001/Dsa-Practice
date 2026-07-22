class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

         int n = s.length();

        // runs -> {char(0/1), start, end}
        List<int[]> runs = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            runs.add(new int[]{s.charAt(i), i, j - 1});
            i = j;
        }

        int totalOnes = 0;
        for (int[] run : runs) {
            if (run[0] == '1') {
                totalOnes += run[2] - run[1] + 1;
            }
        }

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> P = new ArrayList<>();
        ArrayList<Integer> Q = new ArrayList<>();
        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();

        for (int idx = 0; idx < runs.size(); idx++) {
            int[] cur = runs.get(idx);

            if (cur[0] == '1') {

                int a = cur[1];
                int b = cur[2];

                int p, lVal;
                if (idx - 1 >= 0) {
                    p = runs.get(idx - 1)[1];
                    lVal = a - p;
                } else {
                    p = -1;
                    lVal = 0;
                }

                int q, rVal;
                if (idx + 1 < runs.size()) {
                    q = runs.get(idx + 1)[2];
                    rVal = q - b;
                } else {
                    q = n;
                    rVal = 0;
                }

                A.add(a);
                B.add(b);
                P.add(p);
                Q.add(q);
                L.add(lVal);
                R.add(rVal);
            }
        }

        int m = A.size();

        int[] G = new int[m];
        for (i = 0; i < m; i++) {
            G[i] = L.get(i) + R.get(i);
        }

        int[] LOG;
        int[][] sp;

        if (m > 0) {

            LOG = new int[m + 1];
            for (i = 2; i <= m; i++) {
                LOG[i] = LOG[i / 2] + 1;
            }

            int K = LOG[m] + 1;

            sp = new int[K][];
            sp[0] = G.clone();

            for (int k = 1; k < K; k++) {

                int half = 1 << (k - 1);
                int len = 1 << k;

                sp[k] = new int[m - len + 1];

                for (int j = 0; j <= m - len; j++) {
                    sp[k][j] = Math.max(sp[k - 1][j], sp[k - 1][j + half]);
                }
            }

        } else {

            LOG = new int[1];
            sp = new int[0][];
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            if (m == 0) {
                ans.add(totalOnes);
                continue;
            }

            int i1 = upperBound(A, l);
            int i2 = lowerBound(B, r) - 1;

            int gain = 0;

            if (!(i1 >= m || i2 < 0 || i1 > i2)) {

                int candidate;

                if (i1 == i2) {

                    int idx = i1;

                    candidate =
                            (A.get(idx) - Math.max(P.get(idx), l))
                                    + (Math.min(Q.get(idx), r) - B.get(idx));

                } else {

                    int candL =
                            (A.get(i1) - Math.max(P.get(i1), l))
                                    + R.get(i1);

                    int candR =
                            L.get(i2)
                                    + (Math.min(Q.get(i2), r) - B.get(i2));

                    int candMid = Integer.MIN_VALUE;

                    if (i1 + 1 <= i2 - 1) {
                        candMid = rangeMax(sp, LOG, i1 + 1, i2 - 1);
                    }

                    candidate = Math.max(candL, Math.max(candR, candMid));
                }

                gain = candidate;
            }

            ans.add(totalOnes + gain);
        }

        return ans;
    }

    private int rangeMax(int[][] sp, int[] LOG, int l, int r) {
        int k = LOG[r - l + 1];
        return Math.max(sp[k][l], sp[k][r - (1 << k) + 1]);
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
        
