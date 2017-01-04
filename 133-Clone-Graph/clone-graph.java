// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//
//
// OJ's undirected graph serialization:
//
//
// Nodes are labeled uniquely.
//
//
// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//
//
//
//
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//
//
// The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//
//
//
//
// Visually, the graph looks like the following:
//
//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/


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
