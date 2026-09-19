import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to group duplicate elements together
        Arrays.sort(nums);
        // Step 2: Begin the backtracking process
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current valid subset to the final result list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Step 3: Skip duplicates. 
            // If the element is identical to the previous one and we are in the same recursion level, skip it.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element
            currentSubset.add(nums[i]);
            
            // Move onto the next element in the array
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: Remove the last element before the next iteration
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
