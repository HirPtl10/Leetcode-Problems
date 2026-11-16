class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int currDiff = Math.abs(sum - target);
                if(currDiff == 0) {
                    return sum;
                } else if(sum > target) {
                    r--;
                } else {
                    l++;
                }
                if(currDiff < diff) {
                    ans = sum;
                    diff = currDiff;
                }
            }
        }

        return ans;
    }
}