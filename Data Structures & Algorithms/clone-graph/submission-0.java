/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> visitedMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(visitedMap.containsKey(node)){
             return visitedMap.get(node);
        }
        Node cloned = new Node(node.val);
        visitedMap.put(node,cloned);


        if(node.neighbors!=null){
            for(Node n :node.neighbors){
                cloned.neighbors.add(cloneGraph(n));
            }
        }


     return cloned;
    }
}