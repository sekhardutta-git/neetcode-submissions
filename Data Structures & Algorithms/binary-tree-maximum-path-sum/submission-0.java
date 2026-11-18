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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
      maxSum(root);
      return max;
    }
     public int maxSum(TreeNode root) {
        if(root == null) return 0;
        int l = maxSum(root.left);
        int r = maxSum(root.right);
       max = Math.max(max,Math.max(Math.max(Math.max(l+root.val+r,l+root.val),r+root.val), root.val));
    
        return Math.max(Math.max(l+root.val,r+root.val), root.val);
     }
}
