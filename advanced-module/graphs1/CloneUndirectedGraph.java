import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneUndirectedGraph {
    public static void main(String args[]) {
        UndirectedGraphNode graph = new UndirectedGraphNode(1);
        graph.neighbors.add(new UndirectedGraphNode(3));
        graph.neighbors.add(new UndirectedGraphNode(2));
        UndirectedGraphNode firstLevel3rdChild = new UndirectedGraphNode(4);
        graph.neighbors.add(firstLevel3rdChild);
        firstLevel3rdChild.neighbors.add(new UndirectedGraphNode(5));
        firstLevel3rdChild.neighbors.add(new UndirectedGraphNode(6));
        System.out.println(solve(graph));
        // BFSTraversal(graph);
    }

    // public static HashMap<Integer, UndirectedGraphNode> hm = new HashMap<>();
    // public static HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();

    public static UndirectedGraphNode solve(UndirectedGraphNode node) {
        Queue q = new Queue(100000);
        UndirectedGraphNode clonedNode = BFSClone(node, q);
        BFSTraversal(clonedNode);
        return clonedNode;
    }

    public static UndirectedGraphNode BFSClone2(UndirectedGraphNode node, Queue q) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        q.enqueue(node);
        UndirectedGraphNode clonedCurrVertex = new UndirectedGraphNode(node.label);
        hm.put(node, clonedCurrVertex);

        while (!q.isEmpty()) {
            UndirectedGraphNode currVertex = q.dequeue();
            if (hm.containsKey(currVertex)) {
                clonedCurrVertex = hm.get(currVertex);
            } else {
                clonedCurrVertex = new UndirectedGraphNode(currVertex.label);
            }
            ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>)currVertex.neighbors;
            int len = neighbors.size();
            for (int i = 0; i < len; i++) {
                UndirectedGraphNode adjVertex = neighbors.get(i);
                if (hm.containsKey(adjVertex)) {
                    UndirectedGraphNode x = hm.get(adjVertex);
                    x.neighbors.add(new UndirectedGraphNode(adjVertex.label));
                } else {
                    UndirectedGraphNode clonedAdjVertex = new UndirectedGraphNode(adjVertex.label);
                    hm.put(adjVertex, clonedAdjVertex);
                    q.enqueue(adjVertex);
                    clonedCurrVertex.neighbors.add(clonedAdjVertex);
                }
            }
        }
        return hm.get(node);
    }

    public static UndirectedGraphNode BFSClone(UndirectedGraphNode node, Queue q) {
        HashMap<Integer, UndirectedGraphNode> hm = new HashMap<>();
        q.enqueue(node);
        UndirectedGraphNode clonedCurrVertex = new UndirectedGraphNode(node.label);
        hm.put(node.label, clonedCurrVertex);

        while (!q.isEmpty()) {
            UndirectedGraphNode currVertex = q.dequeue();
            if (hm.containsKey(currVertex.label)) {
                clonedCurrVertex = hm.get(currVertex.label);
            }
            // else {clonedCurrVertex = new UndirectedGraphNode(currVertex.label);}
            ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>)currVertex.neighbors;
            int len = neighbors.size();
            for (int i = 0; i < len; i++) {
                UndirectedGraphNode adjVertex = neighbors.get(i);
                if (hm.containsKey(adjVertex.label)) {
                    UndirectedGraphNode x = hm.get(adjVertex.label);
                    x.neighbors.add(new UndirectedGraphNode(adjVertex.label));
                } else {
                    UndirectedGraphNode clonedAdjVertex = new UndirectedGraphNode(adjVertex.label);
                    hm.put(adjVertex.label, clonedAdjVertex);
                    q.enqueue(adjVertex);
                    clonedCurrVertex.neighbors.add(clonedAdjVertex);
                }
            }
        }
        return hm.get(node.label);
    }

    public static void BFSTraversal(UndirectedGraphNode node) {
        Queue q = new Queue(100000);
        q.enqueue(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode top = q.dequeue();
            int len = top.neighbors.size();
            for (int i = 0; i < len; i++) {
                UndirectedGraphNode curr = top.neighbors.get(i);
                System.out.println("curr: " + curr.label);
                q.enqueue(curr);
            }
        }
    }

    static class Queue {
        int length = 0, size = 0, rear = -1, front = 0;
        UndirectedGraphNode[] q;

        Queue(int n) {
            q = new UndirectedGraphNode[n];
            length = n;
        }

        public void enqueue(UndirectedGraphNode n) {
            if (isFull()) {
                System.exit(1);
                System.out.println("Illegal op[E]");
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }

        public UndirectedGraphNode dequeue() {
            if (isEmpty()) {
                System.exit(1);
                System.out.println("Illegal op[D]");
            }
            UndirectedGraphNode temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == length;
        }
    }

    // public static
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
