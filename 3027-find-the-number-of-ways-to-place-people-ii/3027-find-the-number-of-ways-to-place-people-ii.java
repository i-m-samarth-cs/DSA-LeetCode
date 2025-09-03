import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int cnt = 0;

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        Map<Integer, Integer> mpx = new HashMap<>();
        Map<Integer, Integer> mpy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpx.put(points[i][0], mpx.getOrDefault(points[i][0], 0) + 1);
            mpy.put(points[i][1], mpy.getOrDefault(points[i][1], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] < p2[0] && p1[1] < p2[1]) continue;
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;

                boolean check = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int[] p = points[k];
                    int px = p[0], py = p[1];
                    if (px >= p1[0] && px <= p2[0] && py >= p2[1] && py <= p1[1]) {
                        check = false;
                        break;
                    }
                }
                if (check) cnt++;
            }
        }

        for (int val : mpx.values()) {
            cnt += val - 1;
        }
        for (int val : mpy.values()) {
            cnt += val - 1;
        }

        return cnt;
    }
}