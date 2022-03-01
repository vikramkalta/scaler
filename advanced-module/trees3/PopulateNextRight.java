import java.util.ArrayList;
import java.util.HashMap;

public class PopulateNextRight {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        connect(root);
    }

    public static void connect(TreeLinkNode root) {
        HashMap<Integer, ArrayList<TreeLinkNode>> levelMap = new HashMap<>();
        Queue q = new Queue(1000000);
        q.enqueue(new Pair(0, root));
        ArrayList<TreeLinkNode> rootList = new ArrayList<>();
        rootList.add(root);
        levelMap.put(0, rootList);

        while(!q.isEmpty()) {
            Pair front = q.dequeue();
            if (front.node != null) {
                ArrayList<TreeLinkNode> list = new ArrayList<>();
                if (front.node.left != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        list = levelMap.get(front.level + 1);
                        list.add(front.node.left);
                    } else {
                        list.add(front.node.left);
                    }
                    levelMap.put(front.level + 1, list);
                    q.enqueue(new Pair(front.level + 1, front.node.left));
                }
                if (front.node.right != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        list = levelMap.get(front.level + 1);
                        list.add(front.node.right);
                    } else {
                        list.add(front.node.right);
                    }
                    levelMap.put(front.level + 1, list);
                    q.enqueue(new Pair(front.level + 1, front.node.right));
                }
            }
        }

        int level = 0;
        while(levelMap.containsKey(level)) {
            ArrayList<TreeLinkNode> list  = levelMap.get(level);
            for (int i = 0, len = list.size(); i < len - 1; i++) {
                TreeLinkNode node = list.get(i);
                node.next = list.get(i+1);
            }
            level++;
        }
        return;
    }

    static class Pair {
        int level;
        TreeLinkNode node;
        Pair(int _level, TreeLinkNode _node) {
            level = _level;
            node = _node;
        }
    }
    static class Queue {
        int len = 0, size = 0, rear = -1, front = 0;
        Pair[] q;

        Queue(int n) {
            q = new Pair[n];
            len = n;
        }

        public void enqueue(Pair n) {
            if (isFull()) {
                System.out.println("ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            size++;
        }

        public Pair dequeue() {
            if (isEmpty()) {
                System.out.println("ill op[d]");
                System.exit(1);
            }
            Pair temp = q[front];
            front = (front + 1) % len;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == len;
        }
    }
}
