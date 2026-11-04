class Solution {
    
    class Edge {
        int dest;
        int wt;

        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            int edge[] = edges[i];
            int source = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            graph[source].add(new Edge(dest, wt));
        }

        return solve(graph, k, labels);
    }

    int solve(ArrayList<Edge>[] graph, int k, String labels) {
        int dist[][] = new int[graph.length][k + 1];
        for(int i = 0; i < graph.length; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0, 1});
        dist[0][1] = 0;

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int u = curr[0];
            int d = curr[1];
            int currStreak = curr[2];
            if(d > dist[u][currStreak]) continue;
            if(u == graph.length - 1) return d;

            for(Edge e: graph[u]) {
                int v = e.dest;
                int wt = e.wt;

                int newStreak = labels.charAt(u) == labels.charAt(v) ? currStreak + 1 : 1;
                if(newStreak > k) continue;
                if(d + wt < dist[v][newStreak]) {
                    dist[v][newStreak] = d + wt;
                    pq.add(new int[]{v, d + wt, newStreak});
                }
            }
        }

        return -1;
    }
}