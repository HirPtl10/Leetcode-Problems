class Solution {

    class Server {
        int idx;
        int val;
        long end;

        Server(int idx, int val, long end) {
            this.idx = idx;
            this.end = end;
            this.val = val;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int ans[] = new int[tasks.length];

        PriorityQueue<Server> aq = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return Integer.compare(a.val, b.val);
            }

            return Integer.compare(a.idx, b.idx);
        });
        PriorityQueue<Server> bq = new PriorityQueue<>((a, b) -> {
            if (a.end != b.end)
                return Long.compare(a.end, b.end);
            if (a.val != b.val)
                return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < servers.length; i++) {
            aq.add(new Server(i, servers[i], -1));
        }

        long time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            while (!bq.isEmpty() && bq.peek().end <= time) {
                aq.add(bq.remove());
            }

            if (aq.isEmpty()) {
                time = bq.peek().end;

                while (!bq.isEmpty() && bq.peek().end <= time) {
                    aq.add(bq.remove());
                }
            }

            Server server = aq.remove();
            server.end = time + tasks[i];
            ans[i] = server.idx;
            bq.add(server);
        }

        return ans;
    }
}