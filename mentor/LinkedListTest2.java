public class LinkedListTest2 {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedListTest2 insert(LinkedListTest2 list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printLL(LinkedListTest2 list) {
        Node last = list.head;
        while(last!=null) {
            System.out.println("El: " + last.data);
            last = last.next;
        }
    }
    public static void main(String args[]) {
        LinkedListTest2 list = new LinkedListTest2();
        list = insert(list, 1);
        list = insert(list, 2);

        printLL(list);
    }
}
