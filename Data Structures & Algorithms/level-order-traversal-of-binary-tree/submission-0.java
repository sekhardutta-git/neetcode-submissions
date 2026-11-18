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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> level= new ArrayDeque<>();
        List<List<Integer>> levelList = new ArrayList<>();
        checkAndAdd(level,root);
        while(!level.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = level.size();
            for(int i=0;i<size;i++){
                TreeNode n = level.poll();
                l.add(n.val);

                checkAndAdd(level,n.left);
                checkAndAdd(level,n.right);
            }
            levelList.add(l);

        }
        return levelList;

    }

    private void checkAndAdd(Queue<TreeNode> level,TreeNode n){
        if(n!=null)
            level.offer(n);
    }
}
