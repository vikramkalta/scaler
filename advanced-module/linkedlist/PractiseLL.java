public class PractiseLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.append(1);
        ln.append(2);
        ln.append(3);
        ln.append(4);
        // ln.next = new ListNode(2);
        // ln.next.next = new ListNode(3);
        // ln.next.next.next = new ListNode(4);
        ln.print();
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        // Append a new node to the end of the linked list
        public void append(int val) {
            ListNode newNode = new ListNode(val);
            ListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // Print the linked list
        public void print() {
            ListNode current = this;
            while (current != null) {
                System.out.println(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }   
}