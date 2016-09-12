/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        //Copy nodes
        while (start < nodes.size()) {
            UndirectedGraphNode cur = nodes.get(start++);
            for (int i = 0; i < cur.neighbors.size(); i++) {
                UndirectedGraphNode nb = cur.neighbors.get(i);
                while (!map.containsKey(nb)) {
                    map.put(nb, new UndirectedGraphNode(nb.label));
                    nodes.add(nb);
                }
            }
        }
        //Copy neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode addnb = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                addnb.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}