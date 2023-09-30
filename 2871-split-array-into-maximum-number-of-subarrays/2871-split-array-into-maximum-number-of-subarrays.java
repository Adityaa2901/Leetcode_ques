class Solution {
    public int maxSubarrays(int[] nums) {
         int n = nums.length;
        int and = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            and &= nums[i];
        }
        if (and != 0) {
            return 1;
        }
        int max = Integer.MAX_VALUE, temp = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            temp &= num;
            if (temp == 0) {
                count++;
                temp = max;
            }
        }
        return count;
        
    }
}