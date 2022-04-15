// import java.util.LinkedList;

public class SimpleLL {
    Node head;
    public static class Node {
        int value;
        Node next;
        Node(int d) {
            value = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        SimpleLL linkedList = new SimpleLL();
        // Assign value values
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        // Connect nodes
        linkedList.head.next = second;
        second.next = third;

        // printing node-value
        while(linkedList.head!=null) {
            System.out.println(linkedList.head.value);
            linkedList.head = linkedList.head.next;
        }
    }
}
