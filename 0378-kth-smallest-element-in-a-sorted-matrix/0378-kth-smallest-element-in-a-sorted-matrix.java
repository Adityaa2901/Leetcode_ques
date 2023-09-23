class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[0]));
        for (int i = 0; i < Math.min(m, k); i++) {
            h.offer(new int[]{matrix[i][0], i, 0});

        }
        int ans = -1;
        for (int i = 0; i < k; i++) {
            int[] top = h.poll();
            int r = top[1], c = top[2];
            ans = top[0];
            if (c + 1 < n) h.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return ans;
        
    }
}