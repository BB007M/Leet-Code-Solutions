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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // Flag to track traversal direction
        boolean isLeftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Use LinkedList to allow efficient adding to both front and back
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (isLeftToRight) {
                    // Normal order: add to the end
                    currentLevel.add(currentNode.val);
                } else {
                    // Reverse order: add to the front
                    currentLevel.addFirst(currentNode.val);
                }

                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add the completed level to our final results
            result.add(currentLevel);
            // Flip the direction flag for the next level
            isLeftToRight = !isLeftToRight;
        }

        return result;
    }
}
