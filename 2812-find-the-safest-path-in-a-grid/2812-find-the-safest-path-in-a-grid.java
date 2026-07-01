class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

           int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : dir) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
                    dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int low = 0;
        int high = 2 * n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[][] dist, int safe) {
        int n = dist.length;

        if (dist[0][0] < safe)
            return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == n - 1 && curr[1] == n - 1)
                return true;

            for (int[] d : dir) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
                    !vis[nr][nc] &&
                    dist[nr][nc] >= safe) {

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
        
    }
}