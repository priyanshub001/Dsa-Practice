import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[0][1] = 0;
        pq.offer(new int[]{0, 1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int u = curr[0];
            int len = curr[1];
            int cost = curr[2];

            if (cost != dist[u][len])
                continue;

            if (u == n - 1)
                return cost;

            for (int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                int newLen;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newLen = len + 1;
                } else {
                    newLen = 1;
                }

                if (newLen > k)
                    continue;

                int newCost = cost + w;

                if (newCost < dist[v][newLen]) {
                    dist[v][newLen] = newCost;
                    pq.offer(new int[]{v, newLen, newCost});
                }
            }
        }

        return -1;
    }
}