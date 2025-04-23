class Solution {
    public int countLargestGroup(int n) {
        String s = String.valueOf(n + 1);
        int sm = s.length() * 9 + 1;
        int[] dp = new int[sm];
        int x = 0;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            int[] dp2 = new int[sm];

            for (int j = 0; j < sm; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j + k < sm) {
                        dp2[j + k] += dp[j];
                    }
                }
            }

            dp = dp2;

            for (int j = 0; j < digit; j++) {
                if (x + j < sm) {
                    dp[x + j] += 1;
                }
            }

            x += digit;
        }

        dp[0] = 0;
        int maxFreq = 0, count = 0;
        for (int val : dp) {
            if (val > maxFreq) {
                maxFreq = val;
                count = 1;
            } else if (val == maxFreq) {
                count++;
            }
        }
        return count;
    }
}