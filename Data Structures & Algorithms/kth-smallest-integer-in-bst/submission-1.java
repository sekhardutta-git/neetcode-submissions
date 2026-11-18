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
 int n;
 int result;
    public int kthSmallest(TreeNode root, int k) {
        this.n=k;
        result = 0;
         nthSmallest(root);
         return result;
    }

    public void nthSmallest(TreeNode root) {
        if(root ==null || n <= 0){
return;
        }
        nthSmallest(root.left);
        if(n <= 0){
            return;
        }

         n--;
         if(n == 0){
            result =  root.val;
            return;
         }
        
        nthSmallest(root.right);
    }
}
