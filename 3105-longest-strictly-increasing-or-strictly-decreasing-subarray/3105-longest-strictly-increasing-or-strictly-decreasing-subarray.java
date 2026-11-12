class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int ans = 1;
        if(nums.length == 1) return 1;
        int i = 1;
        while(i < nums.length) {
            if(nums[i] < nums[i - 1]) {
                inc++;
                dec = 1;
                ans = Math.max(ans, inc);
            } else if(nums[i] > nums[i - 1]) {
                dec++;
                inc = 1;
                ans = Math.max(ans, dec);
            } else {
                inc = 1;
                dec = 1;
            }
            i++;
        }

        return ans;
    }
}