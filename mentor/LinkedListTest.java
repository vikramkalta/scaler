public class LinkedListTest {
    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;
        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedListTest insert(LinkedListTest list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }else{
            // Else traverse till the last node
            //  and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }

        // Insert the new_node at last node
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedListTest list) {
        Node currNode = list.head;
        System.out.println("LinkedList: ");

        // Traverse through the LinkedList
        while(currNode != null) {
            // Print the data at current node.
            System.out.println(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        LinkedListTest list = new LinkedListTest();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        // Print the LinkedList
        printList(list);
    }
}

// class LL1 {
//     Node head; // head of list

//     // Linked list Node;
//     class Node {
//         int data;
//         Node next;

//         // Constructor to create a new node
//         // Next is by default initialized
//         Node(int d) {
//             data = d;
//             next = null;
//         }
//     }
// }
