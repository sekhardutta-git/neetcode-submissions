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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      encode(root,sb);
      return sb.toString();
    }

    private void encode(TreeNode n, StringBuilder sb){
        if(n == null){
            sb.append("N");
            if(sb.length()!=0){
              sb.append(",");
            }
            return;
        }
        
        sb.append(n.val);
        if(sb.length()!=0){
           sb.append(",");
        }
        
        encode(n.left,sb);
        encode(n.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> values = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return decode(values);
    }

    private TreeNode decode(Queue<String> values){
        String v = values.poll();
        if("N".equals(v)){
        return null;
        }
        TreeNode n = new TreeNode(Integer.parseInt(v));
        TreeNode l = decode(values);
        TreeNode r = decode(values);
        n.left = l;
        n.right=r;
        return n;
    }
}
