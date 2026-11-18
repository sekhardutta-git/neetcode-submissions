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
class Solution {

    class BSTResult {
        boolean isBst;
        int min;
        int max;

        BSTResult(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isBST(root).isBst;
    }

    private BSTResult isBST(TreeNode root) {

        int min = root.val;
        int max = root.val;

        // Validate left subtree
        if (root.left != null) {
            BSTResult left = isBST(root.left);

            if (!left.isBst || left.max >= root.val) {
                return new BSTResult(false, 0, 0);
            }

            min = left.min;
        }

        // Validate right subtree
        if (root.right != null) {
            BSTResult right = isBST(root.right);

            if (!right.isBst || right.min <= root.val) {
                return new BSTResult(false, 0, 0);
            }

            max = right.max;
        }

        return new BSTResult(true, min, max);
    }
}
