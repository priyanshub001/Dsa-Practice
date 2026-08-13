class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int left;
        int right;
        int max;
        int length;

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;
            left = 1;
            right = 1;
            max = 1;
            length = 1;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(arr[start]);
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index) {

        if (start == end) {
            tree[node] = new Node(arr[index]);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        Node res = new Node(a.leftChar);

        res.length = a.length + b.length;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        // Prefix
        res.left = a.left;

        if (a.left == a.length && a.rightChar == b.leftChar) {
            res.left = a.length + b.left;
        }

        // Suffix
        res.right = b.right;

        if (b.right == b.length && a.rightChar == b.leftChar) {
            res.right = b.length + a.right;
        }

        // Maximum
        res.max = Math.max(a.max, b.max);

        if (a.rightChar == b.leftChar) {
            res.max = Math.max(res.max, a.right + b.left);
        }

        return res;
    }
}