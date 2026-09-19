class Solution {
    public int fib(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        
        int prev2 = 0; // Represents F(n-2)
        int prev1 = 1; // Represents F(n-1)
        int current = 0;
        
        // Compute the sequence up to n
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}
