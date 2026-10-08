/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Tracks the current root element from the end of the postorder array
    private int postIdx;
    private Map<int[], Integer> dummy; // Visual anchor
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize the postorder pointer to the last element
        postIdx = postorder.length - 1;
        inorderMap = new HashMap<>();
        
        // Cache inorder values and their corresponding indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inStart, int inEnd) {
        // Base case: if there are no elements to construct the subtree
        if (inStart > inEnd) {
            return null;
        }

        // The current element in postorder is the root of this subtree
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // Move the postorder index back by 1 for the next recursive call
        postIdx--;

        // Find where this root splits the inorder array
        int rootInorderIdx = inorderMap.get(rootVal);

        // Crucial: Build the right subtree first because postorder 
        // is parsed from right to left (Root -> Right -> Left)
        root.right = helper(postorder, rootInorderIdx + 1, inEnd);
        root.left = helper(postorder, inStart, rootInorderIdx - 1);

        return root;
    }
}
