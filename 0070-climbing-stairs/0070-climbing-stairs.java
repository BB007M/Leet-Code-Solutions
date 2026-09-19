class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) {
            return n;
        }
        
        int prev2 = 1; // Ways to reach 1 step below
        int prev1 = 2; // Ways to reach current step
        int current = 0;
        
        // Compute the distinct ways up to step n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}
