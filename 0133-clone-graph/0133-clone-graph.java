/*
// Definition for a Node.
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
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        map = new HashMap<>();
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        dfs(node, cloneNode, map);
        return cloneNode;
    }

    public void dfs(Node node, Node cloneNode, Map<Node, Node> map){
        for(Node neighbor: node.neighbors){
            if(!map.containsKey(neighbor)){
                Node cloneNeighbor = new Node(neighbor.val);
                map.put(neighbor , cloneNeighbor);
                cloneNode.neighbors.add(cloneNeighbor);
                dfs(neighbor , cloneNeighbor, map);
            } else {
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }
    }
}