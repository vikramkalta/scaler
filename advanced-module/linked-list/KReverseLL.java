public class KReverseLL {
    ListNode head;

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static KReverseLL insert(KReverseLL list, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = null;

        if (list.head==null){
            list.head=newNode;
        }else{
            ListNode last = list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printLL(ListNode A) {
        ListNode last = A;
        while(last!=null) {
            System.out.println("el: " + last.val);
            last=last.next;
        }
        
    }

    public static ListNode reverseList(ListNode A, int B) {
        ListNode prev = null, curr = A, next = null;

        ListNode dummyListNode = prev;

        int i = 0;
        while(curr!=null){
            while(i != B) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }
             if (dummyListNode!=null) {
                ListNode last = dummyListNode;
                while(last.next!=null) {
                    last=last.next;
                }
                last.next = prev;
            }
            if (dummyListNode==null){
                dummyListNode = prev;
            }
            prev = null;
            i = 0;
        }
        return dummyListNode;
    }

    public static void main(String args[]) {
        KReverseLL list = new KReverseLL();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        // printLL(list.head);

        ListNode curr = reverseList(list.head, 2);
        printLL(curr);
    }
}
