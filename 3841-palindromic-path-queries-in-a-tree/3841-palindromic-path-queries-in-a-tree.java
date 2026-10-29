import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[][] up;
    int[] depth, tin, tout, bit, val;
    int timer, LOG;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        bit = new int[n + 2];
        val = new int[n];

        int[] parent = new int[n];
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0, size = 0;

        Arrays.fill(parent, -1);
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[size] = u;
            tin[u] = ++timer;
            size++;

            for (int v : adj[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    stack[top++] = v;
                }
            }
        }

        int[] sub = new int[n];
        Arrays.fill(sub, 1);

        for (int i = n - 1; i > 0; i--)
            sub[parent[order[i]]] += sub[order[i]];

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + sub[u] - 1;
            up[0][u] = parent[u];
            val[u] = 1 << (s.charAt(u) - 'a');
        }

        for (int k = 1; k < LOG; k++)
            for (int u = 0; u < n; u++)
                up[k][u] = up[k - 1][up[k - 1][u]];

        for (int u = 0; u < n; u++)
            rangeUpdate(tin[u], tout[u], val[u]);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");
            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                int next = 1 << (p[2].charAt(0) - 'a');
                int delta = val[u] ^ next;

                val[u] = next;
                rangeUpdate(tin[u], tout[u], delta);
            } else {
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);

                int mask = prefix(tin[u]) ^ prefix(tin[v]) ^ val[l];

                ans.add(Integer.bitCount(mask) <= 1);
            }
        }

        return ans;
    }

    void rangeUpdate(int l, int r, int x) {
        update(l, x);
        update(r + 1, x);
    }

    void update(int i, int x) {
        for (; i < bit.length; i += i & -i)
            bit[i] ^= x;
    }

    int prefix(int i) {
        int x = 0;
        for (; i > 0; i -= i & -i)
            x ^= bit[i];
        return x;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int d = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++)
            if ((d & (1 << k)) != 0)
                u = up[k][u];

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}