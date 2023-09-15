class Solution {
     public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 97]++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((i, j) -> (freq[i] >= freq[j]) ? -1 : 1);
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                heap.add(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!heap.isEmpty()) {
            if (heap.size() == 1) {
                if (freq[heap.peek()] == 1) {
                    ans.append((char) (97 + heap.peek()));
                    break;
                } else {
                    return "";
                }
            }
            int f1 = heap.poll();
            int f2 = heap.poll();
            while ((heap.isEmpty() || freq[f2] >= freq[heap.peek()]) && freq[f1] > 0 && freq[f2] > 0) {
                ans.append((char) (f1 + 97));
                ans.append((char) (f2 + 97));
                freq[f1]--;
                freq[f2]--;
            }
            if (freq[f1] > 0) {
                heap.offer(f1);
            }
            if (freq[f2] > 0) {
                heap.offer(f2);
            }


        }
        return ans.toString();

    }
}