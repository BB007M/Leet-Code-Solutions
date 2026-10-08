class Solution {
    public boolean isPowerOfThree(int n) {
        // Base case: numbers less than 1 cannot be a power of three
        if (n < 1) {
            return false;
        }
        
        // Keep dividing by 3 if there is no remainder
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // If it reduces down to 1, it's a power of three
        return n == 1;
    }
}
