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
    // Tracks the current root element moving from left to right in preorder
    private int preIdx;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        inorderMap = new HashMap<>();
        
        // Cache inorder values and their indices for O(1) boundary lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        // Base case: if there are no elements left to construct the subtree
        if (inStart > inEnd) {
            return null;
        }

        // The current element in preorder is the root of this subtree
        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);

        // Move the preorder index forward for the next recursive call
        preIdx++;

        // Find where this root splits the inorder array
        int rootInorderIdx = inorderMap.get(rootVal);

        // Build the left subtree first, then the right subtree
        // (Following the natural Preorder flow: Root -> Left -> Right)
        root.left = helper(preorder, inStart, rootInorderIdx - 1);
        root.right = helper(preorder, rootInorderIdx + 1, inEnd);

        return root;
    }
}
