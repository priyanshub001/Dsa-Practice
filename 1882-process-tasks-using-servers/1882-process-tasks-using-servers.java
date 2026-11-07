import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Free servers: sorted by weight, then index
        PriorityQueue<Integer> free = new PriorityQueue<>((a, b) -> {
            if (servers[a] != servers[b]) {
                return servers[a] - servers[b];
            }
            return a - b;
        });

        // Busy servers: sorted by available time, then weight, then index
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (servers[a[1]] != servers[b[1]]) {
                return servers[a[1]] - servers[b[1]];
            }
            return a[1] - b[1];
        });

        // Initially all servers are free
        for (int i = 0; i < n; i++) {
            free.offer(i);
        }

        long time = 0;

        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);

            // Release all servers that have completed their tasks
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.offer(busy.poll()[1]);
            }

            // If no server is free, jump to earliest available time
            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    free.offer(busy.poll()[1]);
                }
            }

            // Assign current task to the best available server
            int server = free.poll();
            ans[i] = server;

            busy.offer(new int[]{
                (int) (time + tasks[i]),
                server
            });
        }

        return ans;
    }
}