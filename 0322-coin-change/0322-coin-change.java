import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create a DP array to store the min coins needed for each amount up to 'amount'
        int[] dp = new int[amount + 1];
        
        // Fill the array with a value representing "infinity" (amount + 1 is safely out of bounds)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Compute the minimum coins for every sub-amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] wasn't updated, it's impossible to make that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
