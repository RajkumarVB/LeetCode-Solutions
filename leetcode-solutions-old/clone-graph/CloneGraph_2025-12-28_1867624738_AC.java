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
    public Node cloneGraph(Node node) {
        if(node == null) return null; 
        
        HashMap<Node, Node> oldToNewMap = new HashMap<>();
        dfs(node, oldToNewMap); 
        return oldToNewMap.get(node); 
    }

    private void dfs(Node node, HashMap<Node, Node> oldToNewMap){
        if(!oldToNewMap.containsKey(node)){
            oldToNewMap.put(node, new Node(node.val)); 
            for(Node neighbor : node.neighbors){
                if(!oldToNewMap.containsKey(neighbor)){
                    dfs(neighbor,oldToNewMap);
                }
            }

            // I'll be sure that, all the required neighbors are created and in the map. 
            LinkedList<Node> newNeighbors = new LinkedList<>(); 
            for(Node neighbor : node.neighbors){
                newNeighbors.add(oldToNewMap.get(neighbor)); 
            }
            oldToNewMap.get(node).neighbors = newNeighbors; 
        }
    }
}