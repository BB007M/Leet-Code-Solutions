import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the required number already exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store the current number and its index
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found
        return new int[] {};
    }
}
