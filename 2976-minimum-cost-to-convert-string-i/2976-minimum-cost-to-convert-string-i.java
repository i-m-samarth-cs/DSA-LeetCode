class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dis[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dis[u][v] = Math.min(dis[u][v], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s != t) {
                if (dis[s][t] == Integer.MAX_VALUE) return -1;
                res += dis[s][t];
            }
        }
        return res;
    }
}