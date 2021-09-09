public class ReverseLList {
    Node head;

    static class Node {
        public int val;
        public Node next;

        Node(int data) {
            val = data;
            next = null;
        }
    }

    public static ReverseLList insert(ReverseLList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printLL(Node h) {
        Node last = h;
        while (last != null) {
            System.out.println("el: " + last.val);
            last = last.next;
        }
    }

    public static Node reverse(Node A, ReverseLList list) {
        Node curr = A, prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return prev;
    }

    public static Node reverseList(Node A, int B) {
        Node prev = null, curr = A, next = null;

        Node dummyNode = prev;

        int i = 0;
        while(curr!=null){
            while(i != B) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }
             if (dummyNode!=null) {
                Node last = dummyNode;
                while(last.next!=null) {
                    last=last.next;
                }
                last.next = prev;
            }
            if (dummyNode==null){
                dummyNode = prev;
            }
            prev = null;
            i = 0;
        }
        return dummyNode;
    }

    public static void main(String args[]) {
        ReverseLList list = new ReverseLList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        list = insert(list, 9);

        // reverse(list.head, list);
        // reverseList(list.head, 2);
        Node h = reverseList(list.head, 3);
        printLL(h);
    }
}
