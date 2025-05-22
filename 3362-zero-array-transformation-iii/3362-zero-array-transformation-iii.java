class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        // need to iterate over queries with starting point asc
        Arrays.sort(queries, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] effect = new int[nums.length + 1];
        int res = 0;
        // here we store active queries which we can use to cover nums[i]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int j = 0; // queries index
        // now for each index
        for (int i = 0; i < nums.length; i++) {
            // queries we can no longer use
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                pq.poll();
            }

            // same here, moving j over unused queries
            while (j < queries.length && queries[j][1] < i) {
                j++;
            }

            // while our cumulative effect is less than the effect we need
            while (effect[i] < nums[i]) {
                boolean used = false;
                // all the queries we can potentially use go to queue
                while (j < queries.length && queries[j][0] <= i) {
                    pq.add(queries[j]);
                    j++;
                }
                // why we can use some query
                if (!pq.isEmpty()) {
                    int[] tmp = pq.poll();
                    // can't use it - went over its ending
                    if (tmp[1] < i) {
                        continue;
                    }
                    // now let's add cumulative effect
                    effect[i]++;
                    // at this point query ends and we need to take back the effect
                    effect[tmp[1] + 1]--;
                    res++; // using the query
                    used = true;
                }
                // if we can't cover the i - we're out
                if (!used) {
                    return -1;
                }
            }
            // works as prefix sum to cover the ending queries
            effect[i + 1] += effect[i];
        }
        // everything unused is what we can throw off
        return queries.length - res;
    }
}