import java.util.*;

class Solution {
    int n, k;
    int[][] tree;
    int[] prod;
    int[] nums;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.k = k;
        this.n = nums.length;

        tree = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            nums[index] = value;
            update(1, 0, n - 1, index);

            int[] res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res[x];
        }

        return ans;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            int v = nums[l] % k;
            prod[node] = v;
            tree[node][v] = 1;
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int l, int r, int idx) {
        if (l == r) {
            Arrays.fill(tree[node], 0);

            int v = nums[l] % k;
            prod[node] = v;
            tree[node][v] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx);
        } else {
            update(node * 2 + 1, mid + 1, r, idx);
        }

        merge(node, node * 2, node * 2 + 1);
    }

    int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        int[] left = query(node * 2, l, mid, ql, qr);
        int[] right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int leftProd = getProduct(node * 2, l, mid, ql, qr);
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = left[i];
        }

        for (int i = 0; i < k; i++) {
            if (right[i] != 0) {
                int rem = (leftProd * i) % k;
                res[rem] += right[i];
            }
        }

        return res;
    }

    int getProduct(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return prod[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return getProduct(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return getProduct(node * 2 + 1, mid + 1, r, ql, qr);
        }

        int left = getProduct(node * 2, l, mid, ql, qr);
        int right = getProduct(node * 2 + 1, mid + 1, r, ql, qr);

        return (left * right) % k;
    }

    void merge(int node, int left, int right) {
        Arrays.fill(tree[node], 0);

        for (int i = 0; i < k; i++) {
            tree[node][i] += tree[left][i];
        }

        for (int i = 0; i < k; i++) {
            if (tree[right][i] == 0) {
                continue;
            }

            int rem = (prod[left] * i) % k;
            tree[node][rem] += tree[right][i];
        }

        prod[node] = (prod[left] * prod[right]) % k;
    }
}