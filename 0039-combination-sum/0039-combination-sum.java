
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to enable early pruning
        Arrays.sort(candidates);
        
        // 2. Start the recursive backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, 
                           int[] candidates, int remain, int start) {
        // Base Case: If the target is met, add the combination to the result
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: Because the array is sorted, if the current element is greater 
            // than the remaining target, all subsequent elements will also be too large.
            if (candidates[i] > remain) {
                break;
            }

            // Make a choice
            currentList.add(candidates[i]);

            // Recurse: Pass 'i' instead of 'i + 1' because elements can be reused
            backtrack(result, currentList, candidates, remain - candidates[i], i);

            // Backtrack: Undo the choice
            currentList.remove(currentList.size() - 1);
        }
    }
}
