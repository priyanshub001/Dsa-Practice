class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
      int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            graph[u].add(new int[]{v, cost});
            indegree[v]++;

            low = Math.min(low, cost);
            high = Math.max(high, cost);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] topo = new int[n];
        int idx = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;

            for (int[] next : graph[u]) {
                if (--indegree[next[0]] == 0) {
                    queue.offer(next[0]);
                }
            }
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge, List<int[]>[] graph,
                          int[] topo, boolean[] online,
                          long k, int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF) continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < minEdge) continue;

                if (v != n - 1 && !online[v]) continue;

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
            }
        }

        return dist[n - 1] <= k;  
    }
}