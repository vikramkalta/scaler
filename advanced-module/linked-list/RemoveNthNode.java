public class RemoveNthNode {
    public static void main(String args[]) {
        RemoveNthNode list = new RemoveNthNode();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        // printLL(list.head);
        // removeNthFromEnd(list.head, 2);
        // removeNthFromEnd(list.head, 1);
        removeNthFromEnd(list.head, 6);
    }

    ListNode head;

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val=x; next=null;}
    }

    public static RemoveNthNode insert(RemoveNthNode list, int data) {
        ListNode newNode = new ListNode(data);
        if (list.head==null){
            list.head=newNode;
        }else{
            ListNode last = list.head;
            while(last.next!=null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printLL(ListNode A) {
        ListNode last = A;
        while(last != null) {
            System.out.println("last: " + last.val);
            last = last.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int count = 0;
        ListNode last = A;
        while(last!=null) {
            last = last.next;
            count++;
        }
        if (count == 1){
            return null;
        }
        if (B >= count) {
            A = A.next;
            return A;
        }
        int n = count - B - 1;
        count = 0;
        last = A;
        while(count < n) {
            last = last.next;
            count++;
        }
        last.next = last.next.next;
        printLL(A);
        return A;
    }
}
