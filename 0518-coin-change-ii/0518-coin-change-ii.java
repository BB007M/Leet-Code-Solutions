class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] stores the number of combinations to make up amount i
        int[] dp = new int[amount + 1];
        
        // Base case: There is exactly 1 way to make an amount of 0 (by choosing no coins)
        dp[0] = 1;
        
        // Iterate over each coin first to prevent counting duplicate permutations
        for (int coin : coins) {
            // Update the dp array for all amounts that can include the current coin
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}
