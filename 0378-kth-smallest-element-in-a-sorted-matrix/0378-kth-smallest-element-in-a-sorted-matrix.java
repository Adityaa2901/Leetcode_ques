class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int low = matrix[0][0], high = matrix[m-1][m-1], ans = -1;
        while (low <= high) {
            int mid = (low+high) >> 1;
            if (countLessThanOrEqual(matrix, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;


    }

    private int countLessThanOrEqual(int[][] matrix, int target) {
        int n = matrix.length, count = 0, row = 0, col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] <= target) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;

    }
}