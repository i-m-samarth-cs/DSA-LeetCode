class Solution {
    public long sumAndMultiply(int n) {
        // Handle special case where n is 0
        if (n == 0) {
            return 0;
        }
        
        // Extract non-zero digits
        StringBuilder nonZeroDigits = new StringBuilder();
        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0) {
                nonZeroDigits.append(digit);
            }
            temp /= 10;
        }
        
        // If no non-zero digits found, x = 0
        if (nonZeroDigits.length() == 0) {
            return 0;
        }
        
        // Reverse to get original order
        nonZeroDigits.reverse();
        
        // Convert to long for x
        long x = Long.parseLong(nonZeroDigits.toString());
        
        // Calculate sum of digits in x
        long sum = 0;
        long xCopy = x;
        while (xCopy > 0) {
            sum += xCopy % 10;
            xCopy /= 10;
        }
        
        // Return x * sum
        return x * sum;
    }
}