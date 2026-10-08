import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to bring duplicates together
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: Full permutation generated
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Deep copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) {
                continue;
            }

            // Skip duplicates: If the current number matches the previous one,
            // and the previous one hasn't been used yet in this layer, skip it.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Take: Mark as used and add to path
            used[i] = true;
            current.add(nums[i]);

            // Explore: Recurse
            backtrack(nums, current, used, result);

            // Clean up: Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
