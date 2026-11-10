class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[costs.length + 3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;

        for(int i = 3; i < costs.length + 3; i++) {
            int oneJump = dp[i - 1] + costs[i - 3] + 1;
            int twoJump = dp[i - 2] + costs[i - 3] + 4;
            int threeJump = dp[i - 3] + costs[i - 3] + 9;

            dp[i] = Math.min(oneJump, Math.min(twoJump, threeJump));
        }

        return dp[dp.length - 1];
    }
}