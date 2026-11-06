class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int currLen = 0;
        while (j < nums.length) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            if (hm.get(nums[j]) > k) {
                while (hm.get(nums[j]) > k) {
                    hm.put(nums[i], hm.get(nums[i]) - 1);
                    if (hm.get(nums[i]) == 0)
                        hm.remove(nums[i]);
                    i++;
                }
            }
            currLen = j - i + 1;
            maxLen = Math.max(maxLen, currLen);
            j++;
        }

        return maxLen;
    }
}