import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Tracks elements currently in use in the current recursive path
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: if the current list matches the size of nums, a full permutation is found
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Make a deep copy of the list
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip the element if it's already part of the current permutation path
            if (used[i]) {
                continue;
            }

            // Take: Add element and mark it as used
            current.add(nums[i]);
            used[i] = true;

            // Explore: Recurse to build the rest of the permutation
            backtrack(nums, current, used, result);

            // Clean up: Backtrack by removing the element and unmarking it
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
