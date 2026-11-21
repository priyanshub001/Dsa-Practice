class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
         int n = parent.length;
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, children, newParent, last, s);

        List<Integer>[] newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        calculateSize(0, newChildren, ans);

        return ans;
    }

    private void dfs(int node, List<Integer>[] children, int[] newParent,
                     int[] last, String s) {
        int ch = s.charAt(node) - 'a';
        int previous = last[ch];

        if (previous != -1) {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : children[node]) {
            dfs(child, children, newParent, last, s);
        }

        last[ch] = previous;
    }

    private int calculateSize(int node, List<Integer>[] children, int[] ans) {
        int size = 1;

        for (int child : children[node]) {
            size += calculateSize(child, children, ans);
        }

        ans[node] = size;
        return size;
    }
}