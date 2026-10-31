class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !vis[i][j]) {
                    if(isIsland(grid, vis, i, j)) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    boolean isIsland(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || j >= grid[0].length || i >= grid.length) {
            return false;
        }
        if(grid[i][j] == 1 || vis[i][j]) return true;

        vis[i][j] = true;
        boolean left = isIsland(grid, vis, i, j - 1);
        boolean right = isIsland(grid, vis, i, j + 1);
        boolean top = isIsland(grid, vis, i - 1, j);
        boolean down = isIsland(grid, vis, i + 1, j);

        if(left && right && top && down) return true;
        return false;
    }
}