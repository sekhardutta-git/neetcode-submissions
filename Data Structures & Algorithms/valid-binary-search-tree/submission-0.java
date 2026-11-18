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

    public boolean isValidBST(TreeNode root) {
        BSTResult r = isBST(root);
        return r.isBst;
    }

    class BSTResult{
        boolean isBst;
        Integer min;
        Integer max;
    }

    public BSTResult isBST(TreeNode root) {
        boolean isLeftBST = true;
        Integer min = null;
        Integer max = null;
        if(root.left!=null){
            BSTResult l = isBST(root.left);
      isLeftBST = l.isBst && (l.min==null || l.min<root.val) && (l.max==null || l.max<root.val);
      
        min = l.min==null ? root.val : l.min;
      
        
        }else{
            min = root.val;
        }
 boolean isRightBST = true;
        if(isLeftBST && root.right!=null){
            BSTResult r = isBST(root.right);

           isRightBST = r.isBst && (r.min==null || r.min>root.val) && (r.max==null || r.max>root.val);
           max = r.max==null ? root.val : r.max;
        }else{
            max = root.val;
        }

BSTResult result = new BSTResult();
result.isBst = isRightBST && isLeftBST;
result.min = min;
result.max= max;
          return result;
        
    }


}
