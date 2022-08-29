import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public static void main(String args[]) {
        // UndirectedGraphNode root = new UndirectedGraphNode(1);
        // UndirectedGraphNode rootChild1 = new UndirectedGraphNode(3);
        // UndirectedGraphNode rootChild2 = new UndirectedGraphNode(2);
        // UndirectedGraphNode rootChild3 = new UndirectedGraphNode(4);
        // UndirectedGraphNode rightChild1 = new UndirectedGraphNode(5);
        // UndirectedGraphNode rightChild2 = new UndirectedGraphNode(6);
        // root.neighbors.add(rootChild1);
        // root.neighbors.add(rootChild2);
        // root.neighbors.add(rootChild3);
        // rootChild3.neighbors.add(rightChild1);
        // rootChild3.neighbors.add(rightChild2);
        UndirectedGraphNode root = new UndirectedGraphNode(703);
        UndirectedGraphNode root1 = new UndirectedGraphNode(279);
        UndirectedGraphNode root2 = new UndirectedGraphNode(43);
        root.neighbors.add(root);
        root.neighbors.add(root1);
        root.neighbors.add(root2);
        root1.neighbors.add(root);
        root1.neighbors.add(root1);
        root1.neighbors.add(root2);
        root2.neighbors.add(root);
        root2.neighbors.add(root1);
        UndirectedGraphNode clonedGraph = cloneGraph(root);
        System.out.println();
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        UndirectedGraphNode clonedGraph = clone(node, newNodes, visited);
        return clonedGraph;
    }
    public static UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> cloneNodes, HashMap<Integer, Integer> visited) {
        UndirectedGraphNode clonedGraph;
        if (cloneNodes.containsKey(node.label)) {
            clonedGraph = cloneNodes.get(node.label);
        } else {
            clonedGraph = new UndirectedGraphNode(node.label);
            cloneNodes.put(node.label, clonedGraph);
        }
        visited.put(node.label, 1);
        int len = node.neighbors.size();
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            UndirectedGraphNode currNode = node.neighbors.get(i);
            UndirectedGraphNode cloneCurr;
            if (cloneNodes.containsKey(currNode.label)) {
                cloneCurr = cloneNodes.get(currNode.label);
            } else {
                cloneCurr = new UndirectedGraphNode(currNode.label);
                cloneNodes.put(currNode.label, cloneCurr);
            }
            neighbors.add(cloneCurr);
            if (currNode.label != node.label && !visited.containsKey(currNode.label)) {
                clone(currNode, cloneNodes, visited);
            }
        }
        clonedGraph.neighbors = neighbors;
        return clonedGraph;
    }
}
