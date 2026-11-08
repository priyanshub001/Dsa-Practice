class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {

            // Main diagonal
            sum += mat[i][i];

            // Secondary diagonal
            sum += mat[i][n - 1 - i];
        }

        // Remove duplicate center element
        if(n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}