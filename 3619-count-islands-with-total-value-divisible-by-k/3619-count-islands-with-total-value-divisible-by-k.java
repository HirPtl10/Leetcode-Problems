class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] != 0) {
                    long sum = solve(grid, vis, i, j);
                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    long solve(int[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) {
            return 0;
        }
        vis[i][j] = true;
        long left = solve(grid, vis, i, j - 1);
        long right = solve(grid, vis, i, j + 1);
        long top = solve(grid, vis, i - 1, j);
        long down = solve(grid, vis, i + 1, j);

        return (long) grid[i][j] + left + right + top + down;
    }
}