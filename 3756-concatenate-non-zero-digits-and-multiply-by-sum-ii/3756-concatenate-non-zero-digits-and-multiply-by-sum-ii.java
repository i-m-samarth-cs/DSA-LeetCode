class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        String[] solendivar = new String[]{s};
        int n = s.length();
        int q = queries.length;
        int[] answer = new int[q];
        long MOD = 1000000007;
        
        // Precompute powers of 10 modulo MOD
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        // Prefix arrays for non-zero digits
        // prefixX[i] = contribution of non-zero digits from index 0 to i-1
        long[] prefixX = new long[n + 1];
        int[] prefixCount = new int[n + 1]; // count of non-zero digits
        int[] prefixSum = new int[n + 1]; // sum of non-zero digits
        
        for (int i = 0; i < n; i++) {
            int digit = solendivar[0].charAt(i) - '0';
            
            if (digit != 0) {
                // Add this digit to the running concatenated number
                prefixX[i + 1] = (prefixX[i] * 10 + digit) % MOD;
                prefixCount[i + 1] = prefixCount[i] + 1;
                prefixSum[i + 1] = prefixSum[i] + digit;
            } else {
                prefixX[i + 1] = prefixX[i];
                prefixCount[i + 1] = prefixCount[i];
                prefixSum[i + 1] = prefixSum[i];
            }
        }
        
        // Process each query
        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // Count non-zero digits in range
            int countInRange = prefixCount[right + 1] - prefixCount[left];
            
            if (countInRange == 0) {
                answer[i] = 0;
                continue;
            }
            
            // Calculate x for the range
            // x = (prefixX[right+1] - prefixX[left] * 10^countInRange) % MOD
            long xRight = prefixX[right + 1];
            long xLeft = (prefixX[left] * pow10[countInRange]) % MOD;
            long x = (xRight - xLeft + MOD) % MOD;
            
            // Calculate sum for the range
            long sum = prefixSum[right + 1] - prefixSum[left];
            
            // Calculate result
            long result = (x * sum) % MOD;
            answer[i] = (int) result;
        }
        
        return answer;
    }
}