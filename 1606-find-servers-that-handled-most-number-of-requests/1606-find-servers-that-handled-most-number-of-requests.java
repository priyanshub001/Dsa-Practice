import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;

        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < n; i++) {
            int time = arrival[i];

            // Release servers whose requests have completed
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int server = busy.poll()[1];
                available.add(server);
            }

            if (available.isEmpty()) {
                continue; // Drop request
            }

            int preferred = i % k;

            // Find preferred server or next available server
            Integer server = available.ceiling(preferred);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;

            // Store completion time and server ID
            busy.offer(new int[]{time + load[i], server});
        }

        // Find maximum handled requests
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}