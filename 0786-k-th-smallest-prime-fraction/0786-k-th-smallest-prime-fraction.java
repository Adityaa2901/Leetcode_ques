class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingDouble(a -> ((double) arr[a[0]] / arr[a[1]])));
        h.offer(new int[]{0, n - 1});
        visited.add(new Pair<>(0, n - 1));
        int[] ans = new int[2];
        for (int index = 0; index < k; index++) {
            int[] top = h.poll();
            int i = top[0], j = top[1];
            ans[0] = arr[top[0]];
            ans[1] = arr[top[1]];
            if (i < (j - 1) && !visited.contains(new Pair<>(i, j - 1))) {
                h.offer(new int[]{i, j - 1});
                visited.add(new Pair<>(i, j - 1));
            }
            if ((i + 1 < j) && !visited.contains(new Pair<>(i + 1, j))) {
                h.offer(new int[]{i + 1, j});
                visited.add(new Pair<>(i + 1, j));

            }

        }
        return ans;


        
    }
}