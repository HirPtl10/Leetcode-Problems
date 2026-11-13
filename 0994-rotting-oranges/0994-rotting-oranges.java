class Solution {
    class Rotten {
        int i;
        int j;

        Rotten(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Rotten> q = new LinkedList<>();
        int freshInitially = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Rotten(i, j));
                }
                if(grid[i][j] == 1) {
                    freshInitially++;
                }
            }
        }
        if(freshInitially == 0) return 0;
        int ans = -1;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int x = 0; x < n; x++) {
                Rotten curr = q.remove();
                int i = curr.i;
                int j = curr.j;

                if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new Rotten(i - 1, j));
                }

                if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new Rotten(i, j - 1));
                }

                if(i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new Rotten(i + 1, j));
                }

                if(j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new Rotten(i, j + 1));
                }
            }
            ans++;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}