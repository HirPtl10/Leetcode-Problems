class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while(i <= j) {
            ans += (long) (nums[j] * nums[j]);
            if(i != j) ans -= (long) (nums[i] * nums[i]);

            i++;
            j--;
        }

        return ans;
    }
}