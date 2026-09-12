class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
         int n = intervals.size();

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> {
            int x = intervals.get(a).get(0);
            int y = intervals.get(b).get(0);

            if (x != y) return Integer.compare(x, y);

            return Integer.compare(
                intervals.get(a).get(1),
                intervals.get(b).get(1)
            );
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int r = intervals.get(idx[i]).get(1);

            int lo = i + 1;
            int hi = n;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (intervals.get(idx[mid]).get(0) > r)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            next[i] = lo;
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= 4; k++) {
                State skip = dp[i + 1][k];

                if (k == 0) {
                    dp[i][k] = skip;
                    continue;
                }

                int originalIndex = idx[i];
                long weight = intervals.get(originalIndex).get(2);

                State nxt = dp[next[i]][k - 1];

                long takeScore = weight + nxt.score;

                int[] takeIndices = addSorted(nxt.indices, originalIndex);

                State take = new State(takeScore, takeIndices);

                if (take.score > skip.score) {
                    dp[i][k] = take;
                } else if (take.score < skip.score) {
                    dp[i][k] = skip;
                } else {
                    dp[i][k] = compare(take.indices, skip.indices) < 0
                            ? take
                            : skip;
                }
            }
        }

        return dp[0][4].indices;
    }

    private int[] addSorted(int[] arr, int x) {
        int[] res = new int[arr.length + 1];

        int i = 0;
        int j = 0;

        while (i < arr.length && arr[i] < x) {
            res[j++] = arr[i++];
        }

        res[j++] = x;

        while (i < arr.length) {
            res[j++] = arr[i++];
        }

        return res;
    }

    private int compare(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    
}

}