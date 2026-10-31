class Solution {
    long MOD = 1000000007L;
    public int uniquePaths(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        for(long[][] row: dp) {
            for(long[] col: row) {
                Arrays.fill(col, -1);
            }
        }
        return (int) solve(grid, dp, 0, 0, 0);
    }

    long solve(int[][] grid, long[][][] dp, int i, int j, int dir) {
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        if(i < 0 || j < 0 || j >= grid[0].length || i >= grid.length) {
            return 0;
        }

        if(dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        long ans;

        if(grid[i][j] == 1) {
            if(dir == 0) {
                ans = solve(grid, dp, i + 1, j, 1);
            } else {
                ans = solve(grid, dp, i, j + 1, 0);
            }
        } else {
           ans = (solve(grid, dp, i + 1, j, 1) +
            solve(grid, dp, i, j + 1, 0)) % MOD;
        }

        return dp[i][j][dir] = ans;
    }
}