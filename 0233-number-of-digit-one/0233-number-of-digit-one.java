class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        
        // Loop through each digit place (1, 10, 100, 1000, ...)
        // Using long for pow10 to prevent integer overflow when multiplying by 10
        for (long pow10 = 1; pow10 <= n; pow10 *= 10) {
            long divisor = pow10 * 10;
            int quotient = (int) (n / divisor);
            int remainder = (int) (n % divisor);
            
            // 1. Add 1s from the fully completed cycles 
            count += quotient * pow10;
            
            // 2. Add 1s from the remaining, incomplete cycle
            if (remainder >= pow10) {
                count += Math.min(remainder - pow10 + 1, pow10);
            }
        }
        
        return count;
    }
}
